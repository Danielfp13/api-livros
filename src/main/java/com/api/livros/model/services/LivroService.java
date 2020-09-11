package com.api.livros.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.model.domain.Livro;
import com.api.livros.model.repositories.LivroRepository;
import com.api.livros.model.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;

	public List<Livro> findAll() {
		return repository.findAll();
	}

	public Livro find(Integer id) {
		Livro livro = repository.findLivro(id);
		if (livro == null) {
			throw new ObjectNotFoundException(
					"Livro com id " + id + " não encontrado. Em" + Livro.class.getName());
		}
		return livro;
	}

	public Page<Livro> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Livro insert(Livro livro) {
		livro.setId(null);
		livro = repository.save(livro);
		return livro;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);

	}

	public Livro update(Livro livro, Integer id) {
		find(id);
		livro.setId(id);
		livro = repository.save(livro);
		return livro;

	}

}
