package com.br.trentor.Help.me.model.entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

import com.br.trentor.Help.me.model.entities.enumerated.StatusDaMesa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_mesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Comanda comanda;

	@Enumerated(EnumType.STRING)
	private StatusDaMesa status;

	private LocalDateTime inicioOcupacao;
	private LocalDateTime desocupacao;

	private Integer[] numeroOcupantes;

	public Mesa(Long id, Comanda comanda, StatusDaMesa status, LocalDateTime inicioOcupacao, LocalDateTime desocupacao,
			Integer[] numeroOcupantes) {
		this.id = id;
		this.comanda = comanda;
		this.status = status;
		this.inicioOcupacao = inicioOcupacao;
		this.desocupacao = desocupacao;
		this.numeroOcupantes = numeroOcupantes;
	}

	public Mesa() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public StatusDaMesa getStatus() {
		return status;
	}

	public void setStatus(StatusDaMesa status) {
		this.status = status;
	}

	public LocalDateTime getInicioOcupacao() {
		return inicioOcupacao;
	}

	public void setInicioOcupacao(LocalDateTime inicioOcupacao) {
		this.inicioOcupacao = inicioOcupacao;
	}

	public LocalDateTime getDesocupacao() {
		return desocupacao;
	}

	public void setDesocupacao(LocalDateTime desocupacao) {
		this.desocupacao = desocupacao;
	}

	public Long calcularTempoDeMesaAberTa(LocalDateTime inicio, LocalDateTime fim) {
		return Duration.between(inicio, fim).toHours();
	}

	public Integer[] getNumeroOcupantes() {
		return numeroOcupantes;
	}

	public void setNumeroOcupantes(Integer[] numeroOcupantes) {
		this.numeroOcupantes = numeroOcupantes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comanda, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		return Objects.equals(comanda, other.comanda) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Mesa [id=" + id + ", comanda=" + comanda + ", status=" + status + ", inicioOcupacao=" + inicioOcupacao
				+ ", desocupacao=" + desocupacao + "]";
	}

}
