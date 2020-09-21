package com.api.livros.model.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.api.livros.dto.UsuarioUpdateDTO;
import com.api.livros.model.domain.Usuario;
import com.api.livros.model.repositories.UsuarioRepository;
import com.api.livros.resources.exception.FieldMessage;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioUpdateDTO> {
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private UsuarioRepository repo;

	@Override
	public void initialize(UsuarioUpdate ann) {
	}

	@Override
	public boolean isValid(UsuarioUpdateDTO objUpdateDto, ConstraintValidatorContext context) {

		

		@SuppressWarnings("unchecked")
		Map<String, String> map =(Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		
		Integer uriId =Integer.parseInt( map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
 		Usuario aux = repo.findByEmail(objUpdateDto.getEmail());
		if (aux != null  && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
				

		aux = repo.findByCpf(objUpdateDto.getCpf());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("cpf", "Esse CPF já pertence a outro úsuario. "));
		}
			
		aux = repo.findRepeatedPhones(objUpdateDto.getTelefone1());
		if (aux != null  && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("telefone1", "Telefone já existente"));
		}

		aux = repo.findRepeatedPhones(objUpdateDto.getTelefone2());
		if (aux != null  && !aux.getId().equals(uriId)) {
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
