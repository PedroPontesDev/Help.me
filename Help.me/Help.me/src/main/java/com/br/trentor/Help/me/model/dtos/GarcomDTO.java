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

@JsonPropertyOrder({ "id", "nome", "username", "cpf", "horasTrabalhadaMes", "salario", "role" })
public class GarcomDTO {

	private Long id;
	private String nome;
	private String username;
	private String cpf;
	private Duration horasTrabalhadaMes;
	private BigDecimal salario;
	private Role role; // Propriedade para representar a permissão do garçom

	private Set<Comanda> comandaDoGarcom = new TreeSet();

	public GarcomDTO(Long id, String nome, String username, String cpf, Duration horasTrabalhadaMes, BigDecimal salario,
			Role role, Set<Comanda> comandaDoGarcom) {
		super();
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.cpf = cpf;
		this.horasTrabalhadaMes = horasTrabalhadaMes;
		this.salario = salario;
		this.role = role;
		this.comandaDoGarcom = comandaDoGarcom;
	}

	public GarcomDTO() {

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Duration getHorasTrabalhadaMes() {
		return horasTrabalhadaMes;
	}

	public void setHorasTrabalhadaMes(Duration horasTrabalhadaMes) {
		this.horasTrabalhadaMes = horasTrabalhadaMes;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Comanda> getComandaDoGarcom() {
		return comandaDoGarcom;
	}

	public void setComandaDoGarcom(Set<Comanda> comandaDoGarcom) {
		this.comandaDoGarcom = comandaDoGarcom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GarcomDTO other = (GarcomDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "GarcomDTO [id=" + id + ", nome=" + nome + ", username=" + username + ", cpf=" + cpf
				+ ", horasTrabalhadaMes=" + horasTrabalhadaMes + ", salario=" + salario + ", role=" + role
				+ ", comandaDoGarcom=" + comandaDoGarcom + "]";
	}

}
