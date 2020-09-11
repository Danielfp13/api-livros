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

import com.api.livros.model.domain.Cidade;
import com.api.livros.model.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> cidades = service.findAll();
		return ResponseEntity.ok().body(cidades);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> find(@PathVariable Integer id) {
		Cidade cidade = service.find(id);
		return ResponseEntity.ok().body(cidade);

	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Cidade>> findPege(
			@RequestParam(value = "page" , defaultValue = "0") Integer page,
			@RequestParam(value = "linePerPage" , defaultValue = "3") Integer linePerPage, 
			@RequestParam(value = "orderBy" , defaultValue = "id") String orderBy,
			@RequestParam(value = "direction" , defaultValue = "ASC") String direction ) {
		Page<Cidade> lista = service.findPage(page, linePerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Void>insert(@RequestBody Cidade cidade){
		cidade = service.insert(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void>update(@RequestBody Cidade cidade,@PathVariable Integer id){
		cidade = service.update(cidade,id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
