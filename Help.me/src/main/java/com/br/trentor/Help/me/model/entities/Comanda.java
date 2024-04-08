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
	
	@OneToMany
	@JsonIgnore
	private Set<Item> items = new TreeSet<>();
	
	@OneToOne
	private Garcom garcom;
	
	@OneToOne
	private Mesa mesaPertecente;
	
	
	@Column(name = "valor_total_comanda")
	private BigDecimal valorTotalComanda;
	
	
}
