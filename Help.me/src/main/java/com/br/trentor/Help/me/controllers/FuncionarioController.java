package com.br.trentor.Help.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.Help.me.model.dtos.FuncionarioDTO;
import com.br.trentor.Help.me.services.impl.UsuarioServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuario/v1/")
@Tag(name = "Usuario")
public class FuncionarioController {

	@Autowired
	private UsuarioServicesImpl usuarioService;
	
	@Operation(summary = "Cria um usuario no banco")
	public ResponseEntity<FuncionarioDTO> criarUsuario(FuncionarioDTO novoUsuario) {
		return null;
	}
	
	
}
