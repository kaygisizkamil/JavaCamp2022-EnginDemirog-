package com.example.ProgrammingLanguages.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetFrameworkResponse {
	  // private int languageId;
	/*******
	 * Burasi nasil mapping yapmak istediginize bagli alttaki sekilde nested json return eder
	 * ustteki sekilde kullanim yapmak isterseniz tek json ve languagId dahil return eder
	 */
		private GetLanguageResponse languageResponse;
		private int id;
		private String name;
	
	
		
}
