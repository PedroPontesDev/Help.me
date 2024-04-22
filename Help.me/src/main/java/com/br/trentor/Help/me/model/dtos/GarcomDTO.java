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
public class GarcomDTO extends RepresentationModel<GarcomDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String username;
	private String password;
	private String cpf;

	private LocalDateTime horarioSaida;
	private Duration horasTrabalhadas;
	private BigDecimal salario;
	
	private Set<Comanda> comandaDoGarcom = new TreeSet();
	
	private Role permissao = new Role();

	public GarcomDTO(Long id, String nome, String username, String password, String cpf, LocalDateTime horarioSaida,
			Duration horasTrabalhadas, BigDecimal salario, Set<Comanda> comandaDoGarcom, Role permissao) {
		this.id = id;
		this.nome = nome;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.horarioSaida = horarioSaida;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salario = salario;
		this.comandaDoGarcom = comandaDoGarcom;
		this.permissao = permissao;
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

	public LocalDateTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalDateTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public Duration getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(Duration horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Set<Comanda> getComandaDoGarcom() {
		return comandaDoGarcom;
	}

	public void setComandaDoGarcom(Set<Comanda> comandaDoGarcom) {
		this.comandaDoGarcom = comandaDoGarcom;
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
		GarcomDTO other = (GarcomDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "GarcomDTO [id=" + id + ", nome=" + nome + ", username=" + username + ", password=" + password + ", cpf="
				+ cpf + ", horarioSaida=" + horarioSaida + ", horasTrabalhadas=" + horasTrabalhadas + ", salario="
				+ salario + ", comandaDoGarcom=" + comandaDoGarcom + ", permissao=" + permissao + "]";
	}

	
	
}
