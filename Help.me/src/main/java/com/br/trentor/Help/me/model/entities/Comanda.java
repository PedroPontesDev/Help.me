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
	private Garcom garcom;
	
	@OneToOne(mappedBy = "comanda")
	private Mesa mesaPertecente;
	
	@Column(name = "em_aberto")
	private boolean estaAberta;

	@Column(name = "valor_comanda")
	private BigDecimal valorTotalComanda;

	public Comanda(Long id, Garcom garcom, Mesa mesaPertecente, boolean estaAberta, BigDecimal valorTotalComanda) {
		this.id = id;
		this.garcom = garcom;
		this.mesaPertecente = mesaPertecente;
		this.estaAberta = estaAberta;
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
	
	public boolean isEstaAberta() {
		return estaAberta;
	}

	public void setEstaAberta(boolean estaAberta) {
		this.estaAberta = estaAberta;
	}

	@Override
	public String toString() {
		return "Comanda [id=" + id + ", garcom=" + garcom + ", mesaPertecente=" + mesaPertecente + ", estaAberta="
				+ estaAberta + ", valorTotalComanda=" + valorTotalComanda + "]";
	}

	

}
