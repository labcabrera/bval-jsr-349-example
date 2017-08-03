package org.lab.bval.integration.rest;

import org.lab.bval.integration.domain.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Message> exceptionHandler(Exception ex) {
		log.error("Handling exception {}", ex.getMessage());
		Message message = Message.builder().code("000").message(ex.getMessage()).build();
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		// TODO map exception details
		return new ResponseEntity<Message>(message, status);
	}

}