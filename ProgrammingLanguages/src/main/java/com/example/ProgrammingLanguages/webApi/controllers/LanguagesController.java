package com.example.ProgrammingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.requests.CreateLanguagesRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguagesRequest;
import com.example.ProgrammingLanguages.business.responses.GetAllLanguagesResponses;




@RestController
@RequestMapping("api/languages")
public class LanguagesController {
	private LanguagesService languagesService;
	@Autowired
	public LanguagesController(LanguagesService service) {
		this.languagesService=service;
		
	}
	@GetMapping("/getall")
	List<GetAllLanguagesResponses>getAllResponse(){
		return languagesService.getAllResponse();
	}
	@PostMapping("/add")
	public void add(CreateLanguagesRequest createLanguages) {
		this.languagesService.add(createLanguages);
	}
	@PutMapping("update/{id}")
	public void update(@RequestBody UpdateLanguagesRequest updateLanguages,int id) {
		this.languagesService.update(updateLanguages, id);
	}
	
	

}
