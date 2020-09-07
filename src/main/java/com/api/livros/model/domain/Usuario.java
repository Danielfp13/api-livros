package com.api.livros.model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="nome", columnDefinition = "VARCHAR(15)")
	private String nome;
	
	@NotNull
	@Column(name = "email" , columnDefinition = "VARCHAR(150)" , unique = true)
	private String email;
	
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@NotNull
	@Column(name = "senha" , columnDefinition = "varchar(30)" )
	private String senha;
	
	@Column(name = "ativo" , columnDefinition = "boolean")
	private  Boolean ativo;
	
	@NotNull
	@Column(name = "data_cadastro", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	
	@Column(name = "data_atualizacao", columnDefinition = "DATE")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataAtualizacao;
	
	@NotNull
	@Column(name = "telefone1" , columnDefinition = "varchar(15)", unique = true)
	private String telefone1;
	
	@Column(name = "telefone2" , columnDefinition = "varchar(15)", unique = true)
	private String telefone2;
	
	@Column(name = "foto",  columnDefinition = "varchar(255)")
	private String foto;
	
	@Column(name = "cpf" , columnDefinition = "varchar(11)", unique = true)
	private String cpf;
	
	@NotNull
	@Column(name = "termo" , columnDefinition = "boolean")
	private Boolean termo;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nome, String email, Date dataNascimento, String senha, Boolean ativo,
			Date dataCadastro, Date dataAtualizacao, String telefone1, String telefone2, String foto, String cpf,
			Boolean termo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.dataAtualizacao = dataAtualizacao;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.foto = foto;
		this.cpf = cpf;
		this.termo = termo;
		this.endereco = endereco;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
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

	public Boolean getTermo() {
		return termo;
	}

	public void setTermo(Boolean termo) {
		this.termo = termo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

