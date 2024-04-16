package com.br.trentor.Help.me.model.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.hateoas.RepresentationModel;

import com.br.trentor.Help.me.model.entities.Comanda;
import com.br.trentor.Help.me.model.entities.Role;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@JsonPropertyOrder(value = "id, username, passsword, cpf, nome")
public abstract class UsuarioDTO extends RepresentationModel<UsuarioDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String username;
	private String password;
	private String cpf;

	private Role permissao;

	public UsuarioDTO(Long id, String nome, String username, String password, String cpf, Role permissao) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.permissao = permissao;
	}

	public UsuarioDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Role getPermissao() {
		return permissao;
	}

	public void setPermissao(Role permissao) {
		this.permissao = permissao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password
				+ ", cpf=" + cpf + ", permissao=" + permissao + "]";
	}
	
	

}
