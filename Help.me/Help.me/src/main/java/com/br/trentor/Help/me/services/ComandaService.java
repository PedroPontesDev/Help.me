package com.br.trentor.Help.me.services;

import java.util.List;

import com.br.trentor.Help.me.model.dtos.ComandaDTO;

public interface ComandaService {

	ComandaDTO registrarNovaComanda(ComandaDTO novaComanda, Long garcomId) throws Exception;
	ComandaDTO atualizarComandaExistente(ComandaDTO comandaExistente) throws Exception;
	ComandaDTO acharComandaPorId(Long idComanda) throws Exception;
	List<ComandaDTO> listarTodasComandas();
	void deletarComanda(Long idComanda);
	
	
}
