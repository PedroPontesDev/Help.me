package com.devPontes.Help.me.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Comanda {
	//A escrever atributos conforme
	
	@OneToOne(mappedBy = "comanda")
	private Mesa mesa;
	
	 

}
