package com.br.trentor.Help.me.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.FuncionarioDTO;
import com.br.trentor.Help.me.model.dtos.UsuarioDTO;
import com.br.trentor.Help.me.repositories.UsuarioRepositories;

@Service
public class UsuarioServices {

	@Autowired
	UsuarioRepositories userRepository;
	
	public UsuarioDTO registrairNovoUsuario(UsuarioDTO novoUsuarioRegistrado) {
		return null;
		
	}
	
	
}
