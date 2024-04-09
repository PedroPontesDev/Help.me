package com.br.trentor.Help.me.model.entities;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Comanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@OneToMany
//	@JsonIgnore
///	private Set<Item> items = new TreeSet<>();

	@OneToOne
	private Garcom garcom;

	@OneToOne
	private Mesa mesaPertecente;

	@Column(name = "valor_total_comanda")
	private BigDecimal valorTotalComanda;

	public Comanda(Long id, Garcom garcom, Mesa mesaPertecente, BigDecimal valorTotalComanda) {
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

	public Garcom getGarcom() {
		return garcom;
	}

	public void setGarcom(Garcom garcom) {
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
