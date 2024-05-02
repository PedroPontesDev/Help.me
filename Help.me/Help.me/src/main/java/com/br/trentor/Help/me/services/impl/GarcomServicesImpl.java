package com.br.trentor.Help.me.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;
import com.br.trentor.Help.me.model.entities.Garcom;
import com.br.trentor.Help.me.model.entities.Role;
import com.br.trentor.Help.me.model.entities.Usuario;
import com.br.trentor.Help.me.model.entities.security.enumerated.TipoUsuario;
import com.br.trentor.Help.me.model.mapper.MyMaper;
import com.br.trentor.Help.me.repositories.GarcomRepositories;
import com.br.trentor.Help.me.repositories.RoleRepositories;
import com.br.trentor.Help.me.repositories.UsuarioRepositories;
import com.br.trentor.Help.me.services.GarcomServices;

import jakarta.transaction.Transactional;

@Service
public class GarcomServicesImpl implements GarcomServices {

	@Autowired
	GarcomRepositories garcomRepository;

	@Autowired
	RoleRepositories permissaoRepository;

	@Autowired
	UsuarioRepositories userRepository;
	
	@Autowired
	private Logger logger;
	
	@Override
	@Transactional(rollbackOn = Exception.class)
	public GarcomDTO registrarnovoGarcom(GarcomDTO newGarcom) throws Exception {
		if (newGarcom == null)
			throw new IllegalArgumentException("Os dados parecem estar nulos, verifique os dados e tente novamente!");
		// Mapeando as Respectivas Entidades de Garçom para Salvar Como Um Usuario no
		// Banco Respeitando a Metodologia De Herança Do JPA COM A ESTRATÉGIA ->
		// JOINED//
		Garcom novoGarcom = MyMaper.parseObject(newGarcom, Garcom.class);
		Usuario garcomUser = new Usuario(null, novoGarcom.getNome(), novoGarcom.getUsername(), novoGarcom.getPassword(),
				novoGarcom.getCpf(), novoGarcom.getRole());
		garcomUser = userRepository.save(garcomUser);
		// Atribuir a role ao garçom
		Role role = permissaoRepository.findByTipoDeUsuario(TipoUsuario.GARCOM);
		novoGarcom.setRole(role);
		Garcom persisted = garcomRepository.save(novoGarcom);
		var dto = MyMaper.parseObject(persisted, GarcomDTO.class);
		logger.info("Garçom Registred: " + persisted + "-> USER: " +  garcomUser );
		return dto;

	}

	@Override
	public GarcomDTO atualizarGarcomExistente(GarcomDTO garcomExistente) throws Exception {
		if (garcomExistente == null)
			throw new IllegalArgumentException("Os dados parecem estar nulos, verifique os dados e tente novamente!");
		var entityFromDb = garcomRepository.findById(garcomExistente.getId());
		if (entityFromDb.isPresent()) {
			Garcom updated = entityFromDb.get();
			return null;
		}
		return null;
	}

	@Override
	public GarcomDTO findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GarcomDTO> listarTodosGarcom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarUsuario(Long id) {
		// TODO Auto-generated method stub
	}
}
