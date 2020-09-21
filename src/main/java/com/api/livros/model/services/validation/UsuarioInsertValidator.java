package com.api.livros.model.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.livros.dto.UsuarioNewDTO;
import com.api.livros.model.domain.Usuario;
import com.api.livros.model.repositories.UsuarioRepository;
import com.api.livros.resources.exception.FieldMessage;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioNewDTO> {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO objNewDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

 		Usuario aux = repo.findByEmail(objNewDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
				

		aux = repo.findByCpf(objNewDto.getCpf());
		if (aux != null) {
			list.add(new FieldMessage("cpf", "CPF já existente"));
		}
			
		aux = repo.findRepeatedPhones(objNewDto.getTelefone1());
		if (aux != null) {
			list.add(new FieldMessage("telefone1", "Telefone já existente"));
		}

		aux = repo.findRepeatedPhones(objNewDto.getTelefone2());
		if (aux != null) {
			list.add(new FieldMessage("telefone2", "Telefone já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
