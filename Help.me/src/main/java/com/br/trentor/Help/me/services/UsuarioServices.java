package com.br.trentor.Help.me.services;

import com.br.trentor.Help.me.model.dtos.UsuarioDTO;

public interface UsuarioServices {

	UsuarioDTO criarNovoUsuario(UsuarioDTO newUser) throws Exception;
	UsuarioDTO atualizarUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception;
	
}
