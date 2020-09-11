package com.api.livros.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="titulo", columnDefinition = "VARCHAR(100)")
	private String titulo;
	
	@NotNull
	@Column(name="numero_paginas", columnDefinition = "integer")
	private Integer numeroPaginas;
	
	@NotNull
	@Column(name="autor", columnDefinition = "VARCHAR(100)")
	private String autor;
	
	@NotNull
	@Column(name="preco", columnDefinition = "DOUBLE PRECISION")
	private Double preco;
	
	@Column(name="situacao_compra", columnDefinition = "Integer")
	private Integer situacaoCompra;
	
	@Column(name="situacao_atual", columnDefinition = "Integer")
	private Integer situacaoAtual;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "categoria_livro", 
		joinColumns = @JoinColumn(name = "id_livro"),
		inverseJoinColumns = @JoinColumn(name = "id_categoria")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, Integer numeroPaginas, String autor, Double preco, Integer situacaoCompra,
			Integer situacaoAtual, Usuario usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numeroPaginas = numeroPaginas;
		this.autor = autor;
		this.preco = preco;
		this.situacaoCompra = situacaoCompra;
		this.situacaoAtual = situacaoAtual;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getSituacaoCompra() {
		return situacaoCompra;
	}

	public void setSituacaoCompra(Integer situacaoCompra) {
		this.situacaoCompra = situacaoCompra;
	}

	public Integer getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(Integer situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
