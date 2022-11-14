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

import com.example.ProgrammingLanguages.business.abstracts.FrameworkService;
import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.requests.CreateFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetFrameworkResponse;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;




@RestController
@RequestMapping("/api")
public class FrameworksController {
	@Autowired
	private FrameworkService frameworkService;
	@Autowired
	private LanguagesService languageService;
	//@Autowired
	public FrameworksController(FrameworkService service) {
		this.frameworkService=service;
		
	}
	@GetMapping("/frameworks/getall")
	List<GetFrameworkResponse>getAllResponse(){
		return frameworkService.getAllResponse();
	}
	@GetMapping("/frameworks/{id}")
	 public GetFrameworkResponse getById(int id) throws Exception, Exception {
		return frameworkService.getById(id);
	}
	@PostMapping("/frameworks/add")
	public void add(CreateFrameworkRequest createLanguages) throws Exception {
		this.frameworkService.add(createLanguages);
	}
	@PutMapping("/frameworks/update/{id}")
	public void update(@RequestBody UpdateFrameworkRequest updateFramework,@PathVariable int id) throws Exception {
		this.frameworkService.update(updateFramework, id);
		
	}
	@DeleteMapping("/frameworks/delete/{id}")
	public void delete(@RequestBody DeleteFrameworkRequest deleteFramework,@PathVariable int id) throws Exception {
		this.frameworkService.delete(deleteFramework, id);
	}
	
	

}
