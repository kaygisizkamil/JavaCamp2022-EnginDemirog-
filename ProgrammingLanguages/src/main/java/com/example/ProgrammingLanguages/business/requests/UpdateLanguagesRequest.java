package com.example.ProgrammingLanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateLanguagesRequest {
	private String name;

}
