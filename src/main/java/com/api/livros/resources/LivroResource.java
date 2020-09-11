package com.api.livros.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.livros.model.domain.Livro;
import com.api.livros.model.services.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

	@Autowired 
	private LivroService service;
	
	@GetMapping
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> livros = service.findAll();
		return ResponseEntity.ok().body(livros);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro>find(@PathVariable Integer id){
		Livro livro = service.find(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Livro>>findPage(
			@RequestParam(value = "page" ,defaultValue = "0") Integer page, 
			@RequestParam(value = "linePerPage" ,defaultValue = "25") Integer linePerPage, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy" ,defaultValue = "id") String orderBy){
		Page<Livro> lista = service.findPage(page,linePerPage,direction,orderBy);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Livro livro){
		livro = service.insert(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
				
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody Livro livro, @PathVariable Integer id){
		livro = service.update(livro,id);
		return ResponseEntity.noContent().build();
	}
}
