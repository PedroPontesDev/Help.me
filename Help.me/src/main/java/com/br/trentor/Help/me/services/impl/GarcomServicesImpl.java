package com.br.trentor.Help.me.services.impl;

import java.util.List;

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
	    if(novoGarcom == null)   throw new Exception("Os dados parecem estar nulos, verifique os dados e tente novamente!");
	    Garcom newGarcom = MyMaper.parseObject(novoGarcom, Garcom.class);
	    // Verifica se a permissão está nula ou se já está salva no banco de dados
	    if(newGarcom.getPermissao() == null || newGarcom.getPermissao().getId() == null ) {
	        // Cria uma nova permissão para o garçom
	        Role role = new Role();
	        role.setTipoDeUsuario(TipoUsuario.GARCOM);
	        role = permissaoRepository.save(role);
	        // Atribui a permissão ao garçom
	        newGarcom.setPermissao(role);
	    } else {
	    	throw new Exception("O Usuário Já Tem Uma Permissão");
	    }
	    newGarcom = garcomRepository.save(newGarcom);
	    
	    // Converte o garçom salvo de volta para um DTO e o retorna
	    GarcomDTO dto = MyMaper.parseObject(newGarcom, GarcomDTO.class);
	    return dto;
	}


	@Override
	public GarcomDTO atualizarGarcomExistente(GarcomDTO gacomExistente) throws Exception {
		// TODO Auto-generated method stub
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
