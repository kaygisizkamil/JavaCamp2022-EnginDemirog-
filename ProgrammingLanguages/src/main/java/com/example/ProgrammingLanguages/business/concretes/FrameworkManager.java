package com.example.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.ProgrammingLanguages.business.exceptions.DuplicatedNameFound;
import com.example.ProgrammingLanguages.business.exceptions.FrameworkNotFoundException;
import com.example.ProgrammingLanguages.business.exceptions.LanguageNotFoundException;
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
	public void add(CreateFrameworkRequest createRequest) {
		//Languages language = languageRepository.getReferenceById(createRequest.ge		
		if(createRequest.getName()!=null) {
	 		throw new DuplicatedNameFound("Dont dare to duplicate : )");
		}
		
		 Framework framework=new Framework();
		 framework.setName(createRequest.getName());
		framework.setLanguage(languageRepository.findById(createRequest.getLanguageId()).get());
		this.frameworkRepository.save(framework);
		this.frameworkRepository.flush();
		
	}
	@Override
	public void update(UpdateFrameworkRequest updateFrameworkRequest, int id)  {
		if(updateFrameworkRequest.getName()!=null) {
	 		throw new DuplicatedNameFound("Dont dare to duplicate : )");
			}
		//bu kisma ekstra olarak id duplication kontrolü de eklemmeli
		Framework framework=this.frameworkRepository.findById(id).get();
		framework.setName(updateFrameworkRequest.getName());
		framework.setLanguage(languageRepository.findById(updateFrameworkRequest.getLanguageId()).get());
		this.frameworkRepository.save(framework);
		this.frameworkRepository.flush();
	}
	@Override
	public void delete(DeleteFrameworkRequest deleteFrameworkRequest, int id)  {
		 Optional<Framework>framework=this.frameworkRepository.findById(id);
			if (!framework.isPresent())
				throw new FrameworkNotFoundException("id-" + id);
			//Framework framework=this.frameworkRepository.findById(id).get();		
		this.frameworkRepository.delete(framework.get());
		this.frameworkRepository.flush();
		
	}
	
	 @Override
	 public GetFrameworkResponse getById(int id)  {
		 Optional<Framework>framework=this.frameworkRepository.findById(id);
			if (!framework.isPresent())
				throw new FrameworkNotFoundException("id-" + id);
			//Framework framework=frameworkRepository.findById(id).get();
			
			GetFrameworkResponse getFrameworkResponse =new GetFrameworkResponse ();
			getFrameworkResponse .setId(id);
			getFrameworkResponse .setName(framework.get().getName());
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
        			  new GetLanguageResponse (framework.get().getLanguage().getId(),framework.get().getLanguage().getName()));		
			
			return getFrameworkResponse ;
			
			/* GetFrameworkResponse icinde Language yerine int languageId tutarsaniz
			 * {
			 *   languageId:4
			 *   id:1
			 *   framework:"spring" seklinde bir json elde ederken
			 * }
			 */
		//	getFrameworkResponse.setLanguageId(framework.getLanguage().getId());
			
	     
		
		}
	 	

}
