package com.br.trentor.Help.me.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Garcom extends DefaultUser{

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	
	@Column(name = "horario_entrada_semana")
	private LocalDateTime horarioEntrada;
	
	
	@Column(name = "horario_saida_semana")
	private LocalDateTime horarioSaida;
	
	@Column(name = "horas_trabalhadas_mes")
	private LocalDateTime horasTrabalhadas;
	
	@Column(name = "salario_funcionario")
	private Double salario;
	
	public Garcom(String nome, String username, String password, Float cpf, Long id, LocalDateTime horarioEntrada,
			LocalDateTime horarioSaida, LocalDateTime horasTrabalhadas, Double salario) {
		super(nome, username, password, cpf);
		this.id = id;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salario = salario;
	}
	
	public Garcom() {
		
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

	public LocalDateTime getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(LocalDateTime horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	
	
	
}
