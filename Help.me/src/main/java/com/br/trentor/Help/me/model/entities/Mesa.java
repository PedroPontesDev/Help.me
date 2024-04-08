package com.br.trentor.Help.me.model.entities;

import java.time.LocalDateTime;

import com.br.trentor.Help.me.model.entities.enumerateds.StatusDaMesa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "mesaPertencente")
	private Comanda comanda;
	
	@Enumerated(EnumType.STRING)
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
	
	
	
}
