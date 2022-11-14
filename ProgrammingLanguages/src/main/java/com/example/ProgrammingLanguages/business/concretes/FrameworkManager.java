package com.example.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
import com.example.ProgrammingLanguages.dataAccess.concretes.FrameworkRepository;
import com.example.ProgrammingLanguages.dataAccess.concretes.LanguageRepository;
import com.example.ProgrammingLanguages.entities.concretes.Framework;
import com.example.ProgrammingLanguages.entities.concretes.Languages;


@Service

public class FrameworkManager implements FrameworkService {
	
	private FrameworkRepository frameworkRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public FrameworkManager(FrameworkRepository repo,LanguageRepository languageRepository) {
		super();
		this.frameworkRepository=repo;
		this.languageRepository=languageRepository;
	}
	/*List<Languages>languages=this.languageRepository.findAllByOrderByIdAsc();    
		//List<Languages> languages=this.languageRepository.findAll();
		this.languageRepository.flush();
		List<GetLanguageResponse>languageResponse=new ArrayList<>();
		for(Languages language:languages) {
			GetLanguageResponse responseItem=new GetLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}	
		return languageResponse; */
	@Override
	  public List<GetFrameworkResponse> getAllResponse(){
	        List<Framework> frameworks= this.frameworkRepository.findAllByOrderByIdAsc();
	        List<GetFrameworkResponse> frameworkResponses=new ArrayList<>();
	        for(Framework framework:frameworks){
	        	  GetFrameworkResponse responseItem=new GetFrameworkResponse();
	         	  responseItem.setId(framework.getId());
	        	  responseItem.setName(framework.getName());  
	        	  //responseItem.setLanguageResponse(this.languageRepository.7);
	        	  responseItem.setLanguageResponse(
	        			  new GetLanguageResponse (framework.getLanguage().getId(),framework.getLanguage().getName()));
	        	  
	        	 // responseItem.setLanguageId(framework.getLanguage().getId());
	        	  
	        	  /*responseItem.setGetLanguageResponses(new GetLanguageResponse(framework.getLanguage().getId(),
	        			  framework.getLanguage().getName()));*/
	            frameworkResponses.add(responseItem);
	        }
	        return frameworkResponses;
	    }

	@Override
	public void add(CreateFrameworkRequest createRequest) throws Exception {
		//Languages language = languageRepository.getReferenceById(createRequest.ge
		
		// TODO Auto-generated method stub
		 IsValid(createRequest.getName());
		 Framework framework=new Framework();
		 framework.setName(createRequest.getName());
		framework.setLanguage(languageRepository.findById(createRequest.getLanguageId()).get());
		this.frameworkRepository.save(framework);
		this.frameworkRepository.flush();
		
	}
	@Override
	public void update(UpdateFrameworkRequest updateFrameworkRequest, int id) throws Exception {
		// TODO Auto-generated method stub
		 IsValid(updateFrameworkRequest.getName());
		Framework framework=this.frameworkRepository.findById(id).get();
		framework.setName(updateFrameworkRequest.getName());
		framework.setLanguage(languageRepository.findById(updateFrameworkRequest.getLanguageId()).get());
		this.frameworkRepository.save(framework);
		this.frameworkRepository.flush();
		//language=getLanguageById;	
	}
	@Override
	public void delete(DeleteFrameworkRequest deleteFrameworkRequest, int id) throws Exception {
		// TODO Auto-generated method stub
			IsExist(id);
		Framework framework=this.frameworkRepository.findById(id).get();		
		this.frameworkRepository.delete(framework);
		this.frameworkRepository.flush();
		
	}
	 private void IsValid(String name) throws Exception {
			Framework isExist= this.frameworkRepository.findByName(name);
	        if (isExist!=null){
	            throw new Exception("Name already exists");
	        }
	 }
	 @Override
	 public GetFrameworkResponse getById(int id) throws Exception {
			IsExist(id);
						Framework framework=frameworkRepository.findById(id).get();
			
			GetFrameworkResponse getFrameworkResponse =new GetFrameworkResponse ();
			getFrameworkResponse .setId(id);
			getFrameworkResponse .setName(framework.getName());
			/*
			 * Alttaki sekilde bu json dosyasını elde edersinz kullanim amacina gore yazacaginiz manager'i
			 * ve bu dogrultuda web apinizi sekillendirebilirsiniz
						 * [
			  {
			    "languageResponse": {
			      "id": 0,
			      "name": "string"
			    },
			    "id": 0,
			    "name": "string"
			  }
			]
			 */
			getFrameworkResponse.setLanguageResponse(
        			  new GetLanguageResponse (framework.getLanguage().getId(),framework.getLanguage().getName()));		
			/* GetFrameworkResponse icinde Language yerine int languageId tutarsaniz
			 * {
			 *   languageId:4
			 *   id:1
			 *   framework:"spring" seklinde bir json elde ederken
			 * }
			 */
		//	getFrameworkResponse.setLanguageId(framework.getLanguage().getId());
			
	     
			return getFrameworkResponse ;
		}
	 private void IsExist(int id)throws Exception{
		 	/*if(this.frameworkRepository.findById(id).isPresent()) {
		 		throw new Exception("Kayıtlı language bulunamadi");
		 	}*/
		 	if(this.frameworkRepository.findById(id).get()!=null) {
		 		throw new Exception("No language is saved has found");
		 	}
	 }
	 
	

	

}
