package com.br.trentor.Help.me.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.UsuarioDTO;
import com.br.trentor.Help.me.model.entities.Usuario;
import com.br.trentor.Help.me.model.mapper.MyMaper;
import com.br.trentor.Help.me.repositories.UsuarioRepositories;
import com.br.trentor.Help.me.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	UsuarioRepositories userRepository;

	@Override
	public UsuarioDTO criarNovoUsuario(UsuarioDTO newUser) throws Exception {
		Usuario usuario = MyMaper.parseObject(newUser, Usuario.class);
		if (usuario == null) throw new Exception("Dados do usuario não pôde ser confirmado, confira os dados e tente novamente!");
		usuario = userRepository.save(usuario);
		return MyMaper.parseObject(usuario, UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO atualizarUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception {
		if(usuarioExistente == null) throw new Exception("Dados do usuario não pôde ser confirmado, confira os dados e tente novomanete!");
		var entidade = userRepository.findById(usuarioExistente.getId());
		if(entidade.isPresent()) {
			Usuario mileninha = entidade.get();
			mileninha.setCpf(usuarioExistente.getCpf());
			mileninha.setNome(usuarioExistente.getNome());
			mileninha.setPassword(usuarioExistente.getPassword());
			mileninha.setUsername(usuarioExistente.getUsername());
			mileninha = userRepository.save(mileninha);
		} 
		return MyMaper.parseObject(entidade.get(), UsuarioDTO.class);
		
		
		
		
	}

}
