package com.api.livros.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.livros.model.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query(value = "SELECT * FROM categoria WHERE id = :id", nativeQuery = true)
	Categoria findCategoria(Integer id);
}
