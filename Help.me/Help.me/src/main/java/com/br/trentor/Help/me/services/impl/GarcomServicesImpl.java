package com.br.trentor.Help.me.services.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;
import com.br.trentor.Help.me.model.entities.Garcom;
import com.br.trentor.Help.me.model.entities.Role;
import com.br.trentor.Help.me.model.entities.security.enumerated.TipoUsuario;
import com.br.trentor.Help.me.model.mapper.MyMaper;
import com.br.trentor.Help.me.repositories.GarcomRepositories;
import com.br.trentor.Help.me.repositories.RoleRepositories;
import com.br.trentor.Help.me.services.GarcomServices;

import jakarta.transaction.Transactional;

@Service
public class GarcomServicesImpl implements GarcomServices {

	@Autowired
	GarcomRepositories garcomRepository;

	@Autowired
	RoleRepositories permissaoRepository;

	@Override
	@Transactional(rollbackOn = Exception.class)
	public GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception {
	    if (novoGarcom == null)  throw new IllegalArgumentException("Os dados parecem estar nulos, verifique os dados e tente novamente!");
	    
	    // Verifica se o Role para GARCOM está configurado
	    Role garcomRole = permissaoRepository.findByTipoDeUsuario(TipoUsuario.GARCOM);
	    if (garcomRole == null) throw new Exception("A permissão para 'GARCOM' não está configurada no sistema.");
	   
	    // Atribui os atributos ao novo garçom
	    Garcom newGarcom = MyMaper.parseObject(novoGarcom, Garcom.class);
	    newGarcom.setRole(garcomRole);
	    newGarcom.setCpf(novoGarcom.getCpf());
	    newGarcom.setHorasTrabalhadasSemana(novoGarcom.getHorasTrabalhadasSemana());
	    newGarcom.setHorasTrabalhadaMes(novoGarcom.getHorasTrabalhadaMes());
	    newGarcom.setNome(novoGarcom.getNome());
	    newGarcom.setSalario(novoGarcom.getSalario());
	    newGarcom.setUsername(novoGarcom.getUsername());
	    newGarcom.setComandaDoGarcom(new HashSet<>());
	    // Salva o novo garçom no banco de dados
	    newGarcom = garcomRepository.save(newGarcom);

	    // Retorna o DTO correspondente ao novo garçom salvo
	    return MyMaper.parseObject(newGarcom, GarcomDTO.class);
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
