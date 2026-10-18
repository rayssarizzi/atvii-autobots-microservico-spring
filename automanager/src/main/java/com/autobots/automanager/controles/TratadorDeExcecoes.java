package com.autobots.automanager.controles;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeExcecoes {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> tratarConflito(DataIntegrityViolationException excecao) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body("Conflito: violacao de integridade dos dados (valor duplicado ou campo obrigatorio ausente).");
	}
}
