package com.br.trentor.Help.me.model.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
public class ComandaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private GarcomDTO garcomDaComanda;
	private MesaDTO comandaPertencente;
	private boolean comandaEstaAberta;
	private BigDecimal valorTotalComanda;

	public ComandaDTO(Long id, GarcomDTO garcomDaComanda, MesaDTO comandaPertencente, boolean comandaEstaAberta,
			BigDecimal valorTotalComanda) {
		this.id = id;
		this.garcomDaComanda = garcomDaComanda;
		this.comandaPertencente = comandaPertencente;
		this.comandaEstaAberta = comandaEstaAberta;
		this.valorTotalComanda = valorTotalComanda;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GarcomDTO getGarcomDaComanda() {
		return garcomDaComanda;
	}

	public void setGarcomDaComanda(GarcomDTO garcomDaComanda) {
		this.garcomDaComanda = garcomDaComanda;
	}

	public MesaDTO getComandaPertencente() {
		return comandaPertencente;
	}

	public void setComandaPertencente(MesaDTO comandaPertencente) {
		this.comandaPertencente = comandaPertencente;
	}

	public BigDecimal getValorTotalComanda() {
		return valorTotalComanda;
	}

	public void setValorTotalComanda(BigDecimal valorTotalComanda) {
		this.valorTotalComanda = valorTotalComanda;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comandaEstaAberta, comandaPertencente, garcomDaComanda, id, valorTotalComanda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComandaDTO other = (ComandaDTO) obj;
		return comandaEstaAberta == other.comandaEstaAberta
				&& Objects.equals(comandaPertencente, other.comandaPertencente)
				&& Objects.equals(garcomDaComanda, other.garcomDaComanda) && Objects.equals(id, other.id)
				&& Objects.equals(valorTotalComanda, other.valorTotalComanda);
	}

	@Override
	public String toString() {
		return "ComandaDTO [id=" + id + ", garcomDaComanda=" + garcomDaComanda + ", comandaPertencente="
				+ comandaPertencente + ", comandaEstaAberta=" + comandaEstaAberta + ", valorTotalComanda="
				+ valorTotalComanda + "]";
	}

}
