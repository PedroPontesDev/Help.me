package com.br.trentor.Help.me.services;

import java.util.List;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;

public interface GarcomServices {

	GarcomDTO registrarNovoGarcom(GarcomDTO novoGarcom) throws Exception;
	GarcomDTO atualizarGarcomExistente(GarcomDTO gacomExistente) throws Exception;
	GarcomDTO findById(Long id) throws Exception;
	List<GarcomDTO> listarTodosGarcom();
	void deletarUsuario(Long id);
	
	

}
