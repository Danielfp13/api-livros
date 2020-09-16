package com.api.livros.dto;

import com.api.livros.model.domain.Usuario;

public class UsuarioDTO {

	private Integer id;
	
	private String nome;
	
	private String foto;

	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.foto = usuario.getFoto();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
}
