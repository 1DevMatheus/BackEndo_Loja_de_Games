package com.mundodosgames.mundodosgames.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Insira seu nome!")
	private String nome;

	@Schema(example = "email@email.com")
	@NotNull(message = "O atibuto e-mail é obrigatorio")
	@Email(message = "Insira um email valido!")
	private String usuario;

	@NotBlank(message = "Insira sua senha de no minimo 8 caracteres")
	@Size(min = 4, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;


	@OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("produto")
	private List<GamesModel> produto;

	
	public Usuario(Long id, String nome, String usuario, String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	
	}
	public Usuario() {  }


	
	
	
	/* Insira os Getters and Setters */
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<GamesModel> getGames() {
		return this.produto;
	}

	public void setPostagem(List<GamesModel> produto) {
		this.produto = produto;
	}
	
	
	
}
