package com.br.trentor.Help.me.services;

import java.util.List;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;

public interface GarcomServices {

	GarcomDTO registrarnovoGarcom(GarcomDTO newGarcom) throws Exception;
	GarcomDTO atualizarGarcomExistente(GarcomDTO garcomExistent) throws Exception;
	GarcomDTO findById(Long id) throws Exception;
	List<GarcomDTO> listarTodosGarcom();
	void deletarUsuario(Long id);
	
	
	
	

}
