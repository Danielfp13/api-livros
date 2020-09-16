package com.api.livros.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.api.livros.model.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "SELECT * FROM usuario WHERE id = :id" , nativeQuery = true)
	Usuario findUsuario(Integer id);
	
	@Transactional(readOnly = true)
	Usuario findByEmail(String email);
	
	@Transactional(readOnly = true)
	Usuario findByTelefone1(String telefone1);
	
	@Transactional(readOnly = true)
	Usuario findByTelefone2(String telefone2);
	
	@Transactional(readOnly = true)
	Usuario findByCpf(String cpf);
}
