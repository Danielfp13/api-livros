package com.api.livros.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.model.domain.Categoria;
import com.api.livros.model.repositories.CategoriaRepository;
import com.api.livros.model.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria find(Integer id) {
		Categoria obj = repository.findCategoria(id);
		if(obj==null) {
			throw new ObjectNotFoundException("Objeto não encontrado Id:" + id + " , tipo: " + Categoria.class.getName());
		}
		return obj;
	}

	public Categoria insert(Categoria categoria) {
		return repository.save(categoria);
	}

	public void delete(Integer id) {
		find(id);	
		repository.deleteById(id);
		
	}

	public Categoria update(Categoria categoria, Integer id) {
		categoria.setId(id);
		find(categoria.getId());
		return repository.save(categoria);
	}


	public Page<Categoria> findPage(Integer page, Integer linePerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
}
