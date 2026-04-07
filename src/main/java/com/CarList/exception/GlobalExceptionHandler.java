package com.CarList.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.CarList.dto.ExceptionResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Handle Already Exists Exception of Brand
	@ExceptionHandler(BrandAlreadyExistsException.class)
	public ResponseEntity<?> handleBrandAlreadyExistsException
	    (BrandAlreadyExistsException ex, WebRequest webRequest){
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
				(webRequest.getDescription(false), 
						HttpStatus.CONFLICT, 
						ex.getMessage(), 
						LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
	}
	
	// Handle Not Found Exception of Product
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<?> handleBrandNotFoundException
	    (BrandNotFoundException ex, WebRequest webRequest){
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
				(webRequest.getDescription(false), 
						HttpStatus.NOT_FOUND, 
						ex.getMessage(), 
						LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
	}
	
	
	//Global Exception Handle
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException
	    (Exception ex, WebRequest webRequest){
		ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO
				(webRequest.getDescription(false), 
						HttpStatus.INTERNAL_SERVER_ERROR, 
						ex.getMessage(), 
						LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
	}
	
}
