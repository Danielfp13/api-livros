package com.api.livros.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.livros.model.domain.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

	@Query(value = "SELECT * FROM livro WHERE id = :id" , nativeQuery = true)
	Livro findLivro(Integer id);
}
