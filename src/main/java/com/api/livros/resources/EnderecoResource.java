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

import com.api.livros.model.domain.Endereco;
import com.api.livros.model.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired 
	private EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> findAll(){
		List<Endereco> enderecos = service.findAll();
		return ResponseEntity.ok().body(enderecos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Endereco>find(@PathVariable Integer id){
		Endereco endereco = service.find(id);
		return ResponseEntity.ok().body(endereco);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Endereco>>findPage(
			@RequestParam(value = "page" ,defaultValue = "0") Integer page, 
			@RequestParam(value = "linePerPage" ,defaultValue = "25") Integer linePerPage, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy" ,defaultValue = "id") String orderBy){
		Page<Endereco> lista = service.findPage(page,linePerPage,direction,orderBy);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Endereco endereco){
		endereco = service.insert(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
				
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody Endereco endereco, @PathVariable Integer id){
		endereco = service.update(endereco,id);
		return ResponseEntity.noContent().build();
	}
}
