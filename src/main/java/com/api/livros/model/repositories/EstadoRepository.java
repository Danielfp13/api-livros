package com.api.livros.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.livros.model.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	@Query(value = "SELECT * FROM estado WHERE id = :id", nativeQuery = true)
	Estado findEstado(Integer id);
}
