package com.api.livros.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.api.livros.dto.UsuarioDTO;
import com.api.livros.dto.UsuarioNewDTO;
import com.api.livros.dto.UsuarioUpdateDTO;
import com.api.livros.model.domain.Usuario;
import com.api.livros.model.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource{

	@Autowired
	private UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> lista = service.findAll();
		List<UsuarioDTO>listaDto = lista.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> find(@PathVariable Integer id){
		Usuario usuario = service.find(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@GetMapping(value = "/page")
	public ResponseEntity<Page<UsuarioDTO>>findPage(
			@RequestParam(name = "page" , defaultValue = "0") Integer page,
			@RequestParam(name = "linePerPage" , defaultValue = "5") Integer linePerPage,
			@RequestParam(name = "orderBy" , defaultValue = "nome") String orderBy,
			@RequestParam(name = "direction" , defaultValue = "ASC") String direction){
		
		Page<Usuario> lista = service.findPage(page,linePerPage, orderBy, direction);
		Page<UsuarioDTO> listaDto = lista.map(usuario -> new UsuarioDTO(usuario));
		return ResponseEntity.ok().body(listaDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO usuarioNewDto){
		Usuario usuario = service.insert(usuarioNewDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioUpdateDTO usuarioUpdateDTO, @PathVariable Integer id){
		@SuppressWarnings("unused")
		Usuario usuario = service.update(usuarioUpdateDTO, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void>delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
