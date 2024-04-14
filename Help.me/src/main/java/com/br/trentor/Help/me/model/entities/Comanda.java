package com.br.trentor.Help.me.model.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_comandas")
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Funcionario garcom;
	
	@OneToOne(mappedBy = "comanda")
	private Mesa mesaPertecente;

	@Column(name = "valor_comanda")
	private BigDecimal valorTotalComanda;

	public Comanda(Long id, Funcionario garcom, Mesa mesaPertecente, BigDecimal valorTotalComanda) {
		this.id = id;
		this.garcom = garcom;
		this.mesaPertecente = mesaPertecente;
		this.valorTotalComanda = valorTotalComanda;
	}

	public Comanda() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getGarcom() {
		return garcom;
	}

	public void setGarcom(Funcionario garcom) {
		this.garcom = garcom;
	}

	public Mesa getMesaPertecente() {
		return mesaPertecente;
	}

	public void setMesaPertecente(Mesa mesaPertecente) {
		this.mesaPertecente = mesaPertecente;
	}

	public BigDecimal getValorTotalComanda() {
		return valorTotalComanda;
	}

	public void setValorTotalComanda(BigDecimal valorTotalComanda) {
		this.valorTotalComanda = valorTotalComanda;
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", garcom=" + garcom + ", mesaPertecente=" + mesaPertecente
				+ ", valorTotalComanda=" + valorTotalComanda + "]";
	}

}
