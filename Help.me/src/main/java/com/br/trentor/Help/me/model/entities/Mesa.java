package com.br.trentor.Help.me.model.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.br.trentor.Help.me.model.entities.enumerateds.StatusDaMesa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Mesa {

	
	private Long id;
	
	private Comanda comanda;
	
	private StatusDaMesa status;
	
	private LocalDateTime inicioOcupacao;
	private LocalDateTime desocupacao;
	
	public Mesa(Long id, Comanda comanda, StatusDaMesa status, LocalDateTime inicioOcupacao,
			LocalDateTime desocupacao) {
		this.id = id;
		this.comanda = comanda;
		this.status = status;
		this.inicioOcupacao = inicioOcupacao;
		this.desocupacao = desocupacao;
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
	
	public Long calcularTempoDeMesaAbera() {
		return id;
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
