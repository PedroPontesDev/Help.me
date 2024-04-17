package com.br.trentor.Help.me.services.impl;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;
import com.br.trentor.Help.me.repositories.UsuarioRepositories;

@Service
public class ComandaServiceImpl {

	@Autowired
	UsuarioRepositories userRepository;
	
	public GarcomDTO registrairUsuario() {
		return null;
		
	}
	
	
}
