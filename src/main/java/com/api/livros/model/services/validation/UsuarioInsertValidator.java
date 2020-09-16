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
	public boolean isValid(UsuarioNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();

//		if (objDto.getTipo().equals(TipoUsuario.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
//			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
//		}
//
//		if (objDto.getTipo().equals(TipoUsuario.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
//			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
//		}

		Usuario aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}

		aux = repo.findByCpf(objDto.getCpf());
		if (aux != null) {
			list.add(new FieldMessage("cpf", "CPF já existente"));
		}

		aux = repo.findByTelefone1(objDto.getTelefone1());
		if (aux != null) {
			list.add(new FieldMessage("telefone1", "Telefone 1 já existente"));
		}
		
		aux = repo.findByTelefone1(objDto.getTelefone2());
		if(aux != null ) {
			list.add(new FieldMessage("telefone2", "Telefone 2 já existente como op 1"));
		}
		
		if (objDto.getTelefone2() != null || !objDto.getTelefone2().isEmpty()) {
			aux = repo.findByTelefone2(objDto.getTelefone2());
			if (aux != null) {
				list.add(new FieldMessage("telefone2", "Telefone 2 já existente"));
			}
		}

		if (objDto.getTelefone2() != null || !objDto.getTelefone2().isEmpty()) {
			aux = repo.findByTelefone2(objDto.getTelefone1());
			if (aux != null) {
				list.add(new FieldMessage("telefone1", "Telefone 1 já existente como op 2"));
			}
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
