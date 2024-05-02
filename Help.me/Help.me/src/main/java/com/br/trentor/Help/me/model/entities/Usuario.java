package com.br.trentor.Help.me.model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "cpf")
	private String cpf;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Usuario(Long id, String nome, String username, String password, String cpf, Role permissao) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.role = permissao;

	}

	public Usuario() {
		// TODO Auto-generated constructor stub
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
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
		return Objects.equals(id, other.id) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password + ", cpf="
				+ cpf + "]";
	}

}
