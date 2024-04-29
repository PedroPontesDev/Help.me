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

@JsonPropertyOrder(value = "id, username, passsword, cpf, nome, comandaDoGarcom, horasTrabalhadas, salario")
public class GarcomDTO extends RepresentationModel<GarcomDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String username;
	private String password;
	private String cpf;
	private LocalDateTime horasTrabalhadasSemana;
	private Duration horasTrabalhadaMes;
	private BigDecimal salario;
	private Role role;

	private Set<Comanda> comandaDoGarcom = new TreeSet();

	public GarcomDTO(Long id, String nome, String username, String password, String cpf,
			LocalDateTime horasTrabalhadasSemana, Duration horasTrabalhadaMes, BigDecimal salario, Role role,
			Set<Comanda> comandaDoGarcom) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.horasTrabalhadasSemana = horasTrabalhadasSemana;
		this.horasTrabalhadaMes = horasTrabalhadaMes;
		this.salario = salario;
		this.role = new Role();
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

	public LocalDateTime getHorasTrabalhadasSemana() {
		return horasTrabalhadasSemana;
	}

	public void setHorasTrabalhadasSemana(LocalDateTime horasTrabalhadasSemana) {
		this.horasTrabalhadasSemana = horasTrabalhadasSemana;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(comandaDoGarcom, cpf, horasTrabalhadaMes, horasTrabalhadasSemana, id,
				nome, password, role, salario, username);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GarcomDTO other = (GarcomDTO) obj;
		return Objects.equals(comandaDoGarcom, other.comandaDoGarcom) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(horasTrabalhadaMes, other.horasTrabalhadaMes)
				&& Objects.equals(horasTrabalhadasSemana, other.horasTrabalhadasSemana) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && Objects.equals(salario, other.salario)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "GarcomDTO [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password + ", cpf="
				+ cpf + ", horasTrabalhadasSemana=" + horasTrabalhadasSemana + ", horasTrabalhadaMes="
				+ horasTrabalhadaMes + ", salario=" + salario + ", role=" + role + ", comandaDoGarcom="
				+ comandaDoGarcom + "]";
	}
	
	

}
