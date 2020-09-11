package com.api.livros.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.model.domain.Endereco;
import com.api.livros.model.repositories.EnderecoRepository;
import com.api.livros.model.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;

	public List<Endereco> findAll() {
		return repository.findAll();
	}

	public Endereco find(Integer id) {
		Endereco endereco = repository.findEndereco(id);
		if (endereco == null) {
			throw new ObjectNotFoundException(
					"Endereco com id " + id + " não encontrado. Em" + Endereco.class.getName());
		}
		return endereco;
	}

	public Page<Endereco> findPage(Integer page, Integer linePerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	public Endereco insert(Endereco endereco) {
		endereco.setId(null);
		endereco = repository.save(endereco);
		return endereco;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);

	}

	public Endereco update(Endereco endereco, Integer id) {
		find(id);
		endereco.setId(id);
		endereco = repository.save(endereco);
		return endereco;

	}

}
