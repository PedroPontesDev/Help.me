package com.br.trentor.Help.me.model.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DefaultUser {
	
	@Column(name = "nome_pessoal")
	private String nome;
	@Column(name = "username", length = 100, unique = true)
	private String username;
	@Column(name = "password",length = 9, nullable = false )
	private String password;
	@Column(name = "cpf_pessoal", unique = true, nullable = false, length = 200)
	private Float cpf;
	
	public DefaultUser(String nome, String username, String password, Float cpf) {
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
	}

	public DefaultUser() {
		
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

	public Float getCpf() {
		return cpf;
	}

	public void setCpf(Float cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultUser other = (DefaultUser) obj;
		return Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "DefaultUser [nome=" + nome + ", username=" + username + ", password=" + password + ", cpf=" + cpf + "]";
	}
	
	
	
	
	
}
