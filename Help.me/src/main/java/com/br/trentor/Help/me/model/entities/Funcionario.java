package com.br.trentor.Help.me.model.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Usuario {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horario_entrada_dia")
	private LocalDateTime horarioEntrada;

	@Column(name = "horario_saida_dia")
	private LocalDateTime horarioSaida;

	@Column(name = "total_horas_trabalhadas_mes")
	private Duration horasTrabalhadas;
	@Column(name = "salario_funcionario")
	private BigDecimal salario;

	@OneToMany(mappedBy = "garcom")
	private Set<Comanda> comandaDoGarcom = new TreeSet();

	@OneToOne
	Role permisssão;

	public Funcionario(Long id, String nome, String username, String password, String cpf, LocalDateTime horarioEntrada,
			LocalDateTime horarioSaida, Duration horasTrabalhadas, BigDecimal salario, Set<Comanda> comandaDoGarcom,
			Role permissão) {
		super(id, nome, username, password, cpf, permissão);
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salario = salario;
		this.comandaDoGarcom = comandaDoGarcom;
		this.permisssão = permissão;
	}

	public Funcionario() {
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

	public Set<Comanda> getComandaDoGarcom() {
		return comandaDoGarcom;
	}

	public Role getPermisssão() {
		return permisssão;
	}

	public void setPermisssão(Role permisssão) {
		this.permisssão = permisssão;
	}

	public void setComandaDoGarcom(Set<Comanda> comandaDoGarcom) {
		this.comandaDoGarcom = comandaDoGarcom;
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", horasTrabalhadas=" + horasTrabalhadas + ", salario=" + salario + ", comandaDoGarcom="
				+ comandaDoGarcom + ", permisssão=" + permisssão + "]";
	}

	
}
