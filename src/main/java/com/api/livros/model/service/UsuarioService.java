package com.api.livros.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.model.domain.Usuario;
import com.api.livros.model.repository.usuarioRepository;
import com.api.livros.model.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private usuarioRepository repository;

	public List<Usuario> findAll() {
		List<Usuario> usuarios = repository.findAll();
		return usuarios;
	}

	public Usuario find(Integer id) {
		Usuario usuario = repository.findUsuario(id);
		if(usuario == null) {
			throw new ObjectNotFoundException("Objeto com id " + id + "não existe " + "em " + Usuario.class.getName());
		}
		return usuario;
	}

	public Page<Usuario> findPage(Integer page, Integer linePerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Usuario insert(Usuario usuario) {
		usuario = repository.save(usuario);
		return usuario;
	}

	public Usuario update(Usuario usuario, Integer id) {
		usuario.setId(id);
		find(id);
		return repository.save(usuario);
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}
	
	
	
	
}
