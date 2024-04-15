package com.br.trentor.Help.me.services.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.UsuarioDTO;
import com.br.trentor.Help.me.model.entities.Funcionario;
import com.br.trentor.Help.me.model.entities.Usuario;
import com.br.trentor.Help.me.model.mapper.MyMaper;
import com.br.trentor.Help.me.repositories.FuncionarioRepositories;
import com.br.trentor.Help.me.repositories.UsuarioRepositories;
import com.br.trentor.Help.me.services.UsuarioServices;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

	@Autowired
	UsuarioRepositories userRepository;
	
	@Autowired
	FuncionarioRepositories funcionarioRepository;

	@Override
	public UsuarioDTO criarNovoUsuario(UsuarioDTO newUser) throws Exception {
		Usuario usuario = MyMaper.parseObject(newUser, Usuario.class);
		if (usuario == null) throw new Exception("Dados do usuario não pôde ser confirmado, confira os dados e tente novamente!");
		usuario = userRepository.save(usuario);
		Funcionario newFuncUser = new Funcionario(newUser.getId(), newUser.getNome(), newUser.getUsername(), newUser.getPassword(), newUser.getCpf(), null, null, null, null, null, null);
		newFuncUser = funcionarioRepository.save(newFuncUser);
		return MyMaper.parseObject(usuario, UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO atualizarUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception {
		if(usuarioExistente == null) throw new Exception("Dados do usuario não pôde ser confirmado, confira os dados e tente novomanete!");
		var entidade = userRepository.findById(usuarioExistente.getId());
		if(entidade.isPresent()) {
			Usuario user = entidade.get();
			user.setCpf(usuarioExistente.getCpf());
			user.setNome(usuarioExistente.getNome());
			user.setPassword(usuarioExistente.getPassword());
			user.setUsername(usuarioExistente.getUsername());
			user = userRepository.save(user);
			
		} 
		var dto = MyMaper.parseObject(entidade.get(), UsuarioDTO.class);
		return dto;
	}

	@Override
	public UsuarioDTO findById(Long id) throws Exception {
		var entidade = funcionarioRepository.findById(id)
					.orElseThrow(() -> new Exception("Não foi possivel localizar usuario por ID " + id  + ", tente novamente!"));
		if(entidade != null) {
			var dto = MyMaper.parseObject(entidade, UsuarioDTO.class);
			return dto;
		} throw new Exception("Usuario não encontrando");
		
	}

	@Override
	public List<UsuarioDTO> findAll() {
		List<Usuario> todosUsuarios = userRepository.findAll();
		return MyMaper.parseListObjects(todosUsuarios, UsuarioDTO.class);
	}

	
	
}
