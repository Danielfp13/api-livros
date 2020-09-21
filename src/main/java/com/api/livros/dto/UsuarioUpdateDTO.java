package com.api.livros.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.api.livros.model.services.validation.UsuarioUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;

@UsuarioUpdate
public class UsuarioUpdateDTO {

	@NotEmpty(message = "Preenchimento Obrigratório.")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigratório.")
	@Email(message = "Email incorreto.")
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String telefone1;
	
	private String telefone2;

	private String foto;

	@CPF(message = "CPF inválido.")
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String cpf;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String logradouro;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String numero;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String bairro;

	private String complemento;

	@NotEmpty(message = "Preenchimento obrigatório.")
	private String cep;

	@NotNull(message = "Preenchimento obrigatório.")
	private Integer cidadeId;

	public UsuarioUpdateDTO() {
		super();
	}

	public UsuarioUpdateDTO(@NotEmpty(message = "Preenchimento Obrigratório.") String nome,
			@NotEmpty(message = "Preenchimento Obrigratório.") @Email(message = "Email incorreto.") String email,
			Date dataNascimento, @NotEmpty(message = "Preenchimento obrigatório.") String telefone1, String telefone2,
			String foto, @CPF(message = "CPF inválido.") @NotEmpty(message = "Preenchimento obrigatório.") String cpf,
			@NotEmpty(message = "Preenchimento obrigatório.") String logradouro,
			@NotEmpty(message = "Preenchimento obrigatório.") String numero,
			@NotEmpty(message = "Preenchimento obrigatório.") String bairro, String complemento,
			@NotEmpty(message = "Preenchimento obrigatório.") String cep,
			@NotNull(message = "Preenchimento obrigatório.") Integer cidadeId) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.foto = foto;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidadeId = cidadeId;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
}
