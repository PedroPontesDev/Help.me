package com.br.trentor.Help.me.model.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_garcom")
public class Garcom extends Usuario {
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

    @OneToOne(mappedBy = "garcom")
    private Comanda comandaDoGarcom;
    
    @ManyToMany
    @JoinTable(  // Anotação JoinTable define a tabela de junção
    		name = "tb_acessos_usuarios",  // Nome da tabela de junção
    		joinColumns = @JoinColumn(name = "garcom_id", referencedColumnName = "id"),  // JoinColumn para Garcom
    		inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id")) //InverseJoinColumn Para Roles
    
    private List<Role> acessos = new ArrayList<>();

    public Garcom(Long id, String nome, String username, String password, String cpf,
			LocalDateTime horarioEntrada, LocalDateTime horarioSaida, Duration horasTrabalhadas, BigDecimal salario,
			Comanda comandaDoGarcom, List<Role> acessos) {
		super(id, nome, username, password, cpf);
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		this.horasTrabalhadas = horasTrabalhadas;
		this.salario = salario;
		this.comandaDoGarcom = comandaDoGarcom;
		this.acessos = acessos;
	}



	public Garcom() {
        super(); // Adicionei o super() para chamar o construtor padrão da superclasse Usuario
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

	public Comanda getComandaDoGarcom() {
		return comandaDoGarcom;
	}

	public void setComandaDoGarcom(Comanda comandaDoGarcom) {
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
		Garcom other = (Garcom) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Garcom [id=" + id + ", horarioEntrada=" + horarioEntrada + ", horarioSaida=" + horarioSaida
				+ ", horasTrabalhadas=" + horasTrabalhadas + ", salario=" + salario + "]";
	}
	
	
	
	
}
