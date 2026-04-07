package com.CarList.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BrandAlreadyExistsException extends RuntimeException {
	
	public BrandAlreadyExistsException(String message) {
		super(message);
	}

}
