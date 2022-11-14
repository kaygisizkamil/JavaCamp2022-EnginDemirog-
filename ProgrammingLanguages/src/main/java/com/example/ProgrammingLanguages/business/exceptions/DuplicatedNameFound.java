package com.example.ProgrammingLanguages.business.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//conflict kullanilmasinin sebebi bir celiski ? olması aynı name'e ait entity'in tekrar girilecegi icin s
@ResponseStatus(HttpStatus.CONFLICT)

public class DuplicatedNameFound extends RuntimeException {
	public DuplicatedNameFound (String message) {
		super(message);
	}

}
