package com.br.trentor.Help.me.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DefaultUser {

	@Column(name = "nome_pessoal")
	private String nome;
	@Column(name = "username", length = 100, unique = true)
	private String username;
	@Column(name = "cpf_pessoal", unique = true, nullable = false, length = 200)
	private Float cpf;
	private 
	
}
