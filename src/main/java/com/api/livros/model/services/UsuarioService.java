package com.api.livros.model.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.api.livros.dto.UsuarioNewDTO;
import com.api.livros.model.domain.Cidade;
import com.api.livros.model.domain.Endereco;
import com.api.livros.model.domain.Usuario;
import com.api.livros.model.repositories.CidadeRepository;
import com.api.livros.model.repositories.EnderecoRepository;
import com.api.livros.model.repositories.UsuarioRepository;
import com.api.livros.model.services.exceptions.DataIntegrityException;
import com.api.livros.model.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
		

	
	public List<Usuario> findAll() {
		List<Usuario> objs = repository.findAll();
		return objs;
	}

	public Usuario find(Integer id) {
		Usuario obj = repository.findUsuario(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto com id " + id + "não existe " + "em " + Usuario.class.getName());
		}
		return obj;
	}

	public Page<Usuario> findPage(Integer page, Integer linePerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linePerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}

	@Transactional
	public Usuario insert(UsuarioNewDTO obj) {
		Usuario usuario = FromDTO(obj);	
		enderecoRepository.save(usuario.getEndereco());
		usuario = repository.save(usuario);
		return usuario;
	}

	public Usuario update(Usuario obj, Integer id) {
		obj.setId(id);
		find(id);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir esse usuario.");
		}
		
	}
	
	
	public Usuario FromDTO(UsuarioNewDTO obj) {
		
		
		Cidade cidade = cidadeRepository.getOne(obj.getCidadeId());
		
		Endereco endereco = new Endereco(null,obj.getLogradouro(),obj.getNumero(),obj.getBairro(),obj.getComplemento(),obj.getCep(), cidade);
		
		Usuario usuario = new Usuario(null,obj.getNome(), obj.getEmail(), obj.getDataNascimento(),
				obj.getSenha(), true, new Date(), null, obj.getTelefone1(), obj.getTelefone2(),
				obj.getFoto(), obj.getCpf(), obj.getTermo(),endereco);
		
		return usuario;
	}
	
}
