package com.br.trentor.Help.me.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.trentor.Help.me.model.dtos.GarcomDTO;
import com.br.trentor.Help.me.services.impl.ComandaServiceImpl;
import com.br.trentor.Help.me.services.impl.GarcomServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/garcom/v1/")
@Tag(name = "Garcoms")
public class GarcomController {

	@Autowired
	private ComandaServiceImpl comandaSerivces;
	
	@Autowired
	private GarcomServicesImpl garcomServices;
	
	@Operation(summary = "Registrar novo garçom ao banco de dados", description = "Method is gonna be implemented authorization, everthing is beeing builded")
	@PostMapping(path = "/registrar-garcom")
	public ResponseEntity<GarcomDTO> registrarNovoGarcom(@RequestBody GarcomDTO novoGarcom) throws Exception {
		GarcomDTO register = garcomServices.registrarNovoGarcom(novoGarcom);
		return new ResponseEntity<>(register, HttpStatus.CREATED);
	}
	
}
