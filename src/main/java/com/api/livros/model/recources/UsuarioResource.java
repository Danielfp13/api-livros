package com.api.livros.model.recources;

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

import com.api.livros.model.domain.Usuario;
import com.api.livros.model.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource{

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario usuario = service.find(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping(value = "/pages")
	public ResponseEntity<Page<Usuario>>findPage(
			@RequestParam(name = "page" , defaultValue = "0") Integer page,
			@RequestParam(name = "linePerPage" , defaultValue = "5") Integer linePerPage,
			@RequestParam(name = "orderBy" , defaultValue = "nome") String orderBy,
			@RequestParam(name = "direction" , defaultValue = "ASC") String direction){
		
		Page<Usuario> lista = service.findPage(page,linePerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Usuario usuario){
		usuario = service.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Integer id){
		usuario = service.update(usuario, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
