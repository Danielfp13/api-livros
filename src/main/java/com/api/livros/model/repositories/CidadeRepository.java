package com.api.livros.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.livros.model.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	@Query(value = "SELECT * FROM cidade WHERE id = :id", nativeQuery = true)
	Cidade findCidade(Integer id);
}
