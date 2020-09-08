package com.api.livros.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.model.domain.Cidade;
import com.api.livros.model.repository.CidadeRepository;
import com.api.livros.model.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public List<Cidade> findAll() {
		return  repository.findAll();
		
	}

	public Cidade find(Integer id) {
		Cidade cidade = repository.findCidade(id);
		if(cidade == null) {
			throw new ObjectNotFoundException("A Cidade com id = " + id + " não existe!");
		}
		return cidade;
	}

	public Page<Cidade> findPage(Integer page, Integer linePerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction),orderBy);
		return repository.findAll(pageRequest) ;
	}

	public Cidade insert(Cidade cidade) {
		cidade = repository.save(cidade);
		return cidade;
	}

	public Cidade update(Cidade cidade, Integer id) {
		cidade.setId(id);
		find(id);
		cidade = repository.save(cidade);
		return cidade;
	}

	public void delete(Integer id) {
		find(id);
		repository.deleteById(id);
	}
}
