package com.devPontes.Help.me.model.entities;

import java.time.LocalDateTime;

import com.devPontes.Help.me.model.entities.enums.StatusDaMesa;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "")
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated
	private StatusDaMesa statusDaMesa;
	
	@OneToOne
	private Comanda comanda;
	
	private LocalDateTime inicioOcupação;
	private LocalDateTime terminoOcupação;

	
	
	

}
