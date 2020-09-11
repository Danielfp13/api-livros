package com.api.livros.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.livros.model.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	@Query(value = "SELECT * FROM endereco WHERE id = :id", nativeQuery = true)
	Endereco findEndereco(Integer id);
}
