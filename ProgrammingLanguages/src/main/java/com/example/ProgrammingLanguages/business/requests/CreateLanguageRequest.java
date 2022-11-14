package com.example.ProgrammingLanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Setter
public class CreateLanguageRequest {
		private String name;
}
