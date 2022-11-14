package com.example.ProgrammingLanguages.business.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class FrameworkNotFoundException  extends RuntimeException {
	public FrameworkNotFoundException(String message) {
		super(message);
	}

}
