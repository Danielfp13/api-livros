package com.api.livros.dto;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.api.livros.model.services.validation.UsuarioInsert;
import com.fasterxml.jackson.annotation.JsonFormat;

@UsuarioInsert
public class UsuarioNewDTO {

	@NotNull(message = "Preenchimento Obrigratório.")
	@NotEmpty(message = "Preenchimento Obrigratório.")
	private String nome;

	@NotEmpty(message = "Preenchimento Obrigratório.")
	@Email(message = "Email incorreto.")
	private String email;

	@NotEmpty(message = "Preenchimento Obrigratório.")
	@Length(min = 8, max = 20, message = "A senha deve ter de 8 a 20 caracteres")
	private String senha;

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

	@AssertTrue(message = "Tem que aceitar o termo de uso")
	private Boolean termo;

	public UsuarioNewDTO() {
		super();
	}

	public UsuarioNewDTO(String nome, String email, String senha, Date dataNascimento, String telefone1,
			String telefone2, String foto, String cpf, String logradouro, String numero, String bairro,
			String complemento, String cep, Integer cidadeId, Boolean termo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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
		this.termo = termo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public Boolean getTermo() {
		return termo;
	}

	public void setTermo(Boolean termo) {
		this.termo = termo;
	}
}
