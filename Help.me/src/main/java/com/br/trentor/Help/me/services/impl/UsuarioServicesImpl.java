package com.br.trentor.Help.me.services.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.UsuarioDTO;
import com.br.trentor.Help.me.model.entities.Garcom;
import com.br.trentor.Help.me.model.entities.Role;
import com.br.trentor.Help.me.model.entities.Usuario;
import com.br.trentor.Help.me.model.entities.security.enumerated.TipoUsuario;
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
		usuario.getPermissao().setTipoDeUsuario(TipoUsuario.COMUM);
		usuario = userRepository.save(usuario);
		return MyMaper.parseObject(usuario, UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO atualizarUsuarioExistente(UsuarioDTO usuarioExistente) throws Exception {
		if(usuarioExistente == null) throw new Exception("Dados do usuario não pôde ser confirmado, confira os dados e tente novomanete!");
		var entidade = userRepository.findById(usuarioExistente.getId());
		if(entidade.isPresent() && entidade.get().getPermissao().getTipoDeUsuario() == TipoUsuario.ADMINISTRADOR){
			Usuario user = entidade.get();
			user.setCpf(usuarioExistente.getCpf());
			user.setNome(usuarioExistente.getNome());
			user.setPassword(usuarioExistente.getPassword());
			user.setUsername(usuarioExistente.getUsername());
			user = userRepository.save(user);
		} else {
			throw new Exception("Usuario não é administrador ou estpa unulo, verifique e tente novamente!");
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

	@Override
	public void deletarUsuario(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	
}
