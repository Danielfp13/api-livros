package com.api.livros.model.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.livros.model.domain.Usuario;
import com.api.livros.model.repositories.UsuarioRepository;

public class EmailDuplicadoValidator implements ConstraintValidator<EmailDuplicado, String> {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public void initialize(EmailDuplicado ann) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {

		Usuario aux = repo.findByEmail(email);
		if (aux != null) {
			return false;
		}

		return true;
	}

}
