package com.br.trentor.Help.me.model.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Garcom extends DefaultUser {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;

	@Column(name = "horario_entrada_semana")
	private LocalDateTime horarioEntrada;

	@Column(name = "horario_saida_semana")
	private LocalDateTime horarioSaida;

	@Column(name = "total_horas_trabalhadas_mes")
	private Duration horasTrabalhadas;

	@Column(name = "salario_funcionario")
	private BigDecimal salario;
	
	@OneToOne(mappedBy = "garcom")
	private Comanda comandaDoGarcom;

	public Garcom(String nome, String username, String password, Float cpf, Long id, LocalDateTime horarioEntrada,
			LocalDateTime horarioSaida, Duration horasTrabalhadas, BigDecimal salario) {
		super(nome, username, password, cpf);
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salario = salario;
	}

	public Garcom() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(LocalDateTime horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
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
	
	public Long calcularHorasTrabalhadas(LocalDateTime horarioEntrada, LocalDateTime horarioSaida) {
		Duration calculoPorHora = Duration.between(horarioEntrada, horarioSaida);
		this.horasTrabalhadas = calculoPorHora;
		return calculoPorHora.toHours();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Garcom other = (Garcom) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Garcom [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", horasTrabalhadas=" + horasTrabalhadas + ", salario=" + salario + "]";
	}
	
	
	
	
}
