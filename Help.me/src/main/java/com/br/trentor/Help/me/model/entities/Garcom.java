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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
public class Garcom extends Usuario {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "horas_trabalhadas_semana")
	private LocalDateTime horasTrabalhadasSemana;

	@Column(name = "total_horas_trabalhadas_mes")
	private Duration horasTrabalhadaMes;

	@Column(name = "salario_funcionario")
	private BigDecimal salario;

	@OneToMany(mappedBy = "garcom")
	private Set<Comanda> comandaDoGarcom = new TreeSet<>();

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Garcom(Long id, String nome, String username, String password, String cpf, Role permissao,
			LocalDateTime horasTrabalhadasSemana, Duration horasTrabalhadaMes, BigDecimal salario,
			Set<Comanda> comandaDoGarcom, Role role) {
		super(id, nome, username, password, cpf, role);
		this.horasTrabalhadasSemana = horasTrabalhadasSemana;
		this.horasTrabalhadaMes = horasTrabalhadaMes;
		this.salario = salario;
		this.comandaDoGarcom = comandaDoGarcom;
		this.role = role;
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

	public Set<Comanda> getComandaDoGarcom() {
		return comandaDoGarcom;
	}

	public void setComandaDoGarcom(Set<Comanda> comandaDoGarcom) {
		this.comandaDoGarcom = comandaDoGarcom;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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

	public Long calcularHorasTrabalhadas(LocalDateTime horarioEntradaDia, LocalDateTime horarioSaidaDia) {
		Duration calculo = Duration.between(horarioEntradaDia, horarioSaidaDia);
		Long horasTrabalhadas = calculo.toHours();
		return horasTrabalhadas;
	}

	@Override
	public String toString() {
		return "Garcom [id=" + id + ", horasTrabalhadasSemana=" + horasTrabalhadasSemana + ", horasTrabalhadaMes="
				+ horasTrabalhadaMes + ", salario=" + salario + ", comandaDoGarcom=" + comandaDoGarcom + ", role="
				+ role + "]";
	}

	
}
