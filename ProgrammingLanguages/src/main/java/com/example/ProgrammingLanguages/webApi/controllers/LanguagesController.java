package com.example.ProgrammingLanguages.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;




@RestController
@RequestMapping("/api")
public class LanguagesController {
	private LanguagesService languagesService;
	@Autowired
	public LanguagesController(LanguagesService service) {
		this.languagesService=service;
		
	}
	@GetMapping("/languages/getall")
	List<GetLanguageResponse>getAllResponse(){
		return languagesService.getAllResponse();
	}
	@GetMapping("languages/{id}")
	public GetLanguageResponse getLanguageById(@PathVariable int id)  {
		return this.languagesService.getLanguageById(id);
	}
	@PostMapping("/languages/add")
	public void add(CreateLanguageRequest createLanguages){
		this.languagesService.add(createLanguages);
	}
	@PutMapping("/languages/update/{id}")
	public void update(@RequestBody UpdateLanguageRequest updateLanguages,@PathVariable int id) {
		this.languagesService.update(updateLanguages, id);
		
	}
	@DeleteMapping("/languages/delete/{id}")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguages,@PathVariable int id) {
		this.languagesService.delete(deleteLanguages, id);
	}
	
	

}
