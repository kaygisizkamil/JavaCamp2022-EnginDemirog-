package com.example.ProgrammingLanguages.business.exceptions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;

}
