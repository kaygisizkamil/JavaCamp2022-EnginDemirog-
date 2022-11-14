package com.example.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.exceptions.DuplicatedNameFound;
import com.example.ProgrammingLanguages.business.exceptions.LanguageNotFoundException;
import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;
import com.example.ProgrammingLanguages.dataAccess.concretes.LanguageRepository;
import com.example.ProgrammingLanguages.entities.concretes.Languages;
import java.util.Optional.*;

@Service

public class LanguagesManager implements LanguagesService {

	private LanguageRepository languageRepository;
	@Autowired
	public LanguagesManager(LanguageRepository repo) {
		super();
		this.languageRepository=repo;
	}
	@Override
	public List<GetLanguageResponse> getAllResponse() {
		// TODO Auto-generated method stub
		List<Languages>languages=this.languageRepository.findAllByOrderByIdAsc();    
		//bunu kullanmamin sebebi listte eleman sildikten elemanlar sonra sacma sapan sırasız geliyordu bu onu duzeltti
		this.languageRepository.flush();
		List<GetLanguageResponse>languageResponse=new ArrayList<>();
		for(Languages language:languages) {
			GetLanguageResponse responseItem=new GetLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}	
		return languageResponse; 	
	
		
	}
	public void add(int id) {
		
	}

	@Override
	public GetLanguageResponse getLanguageById(int id) {
	//Languages language=this.languageRepository.findById(id).get();
		Optional<Languages>language=this.languageRepository.findById(id);
		if (!language.isPresent())
			throw new LanguageNotFoundException("id-" + id);
		GetLanguageResponse response=new GetLanguageResponse();
		response.setId(language.get().getId());
		response.setName(language.get().getName());
		return response;
	}
	@Override
	public void add(CreateLanguageRequest createRequest) {
		// TODO Auto-generated method stub
        if(createRequest.getName()!=null) {
	 		throw new DuplicatedNameFound("Dont dare to duplicate : )");
        }
		// IsDuplicated(createRequest.getName());
		Languages language=new Languages();
		language.setName(createRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
		
	}
	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id)  {
		 if(updateLanguageRequest.getName()!=null) {
		 		throw new DuplicatedNameFound("Dont dare to duplicate : )");

		 }
		Languages language=this.languageRepository.findById(id).get();
		language.setName(updateLanguageRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
	}
	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest, int id) {
		Optional<Languages>language=this.languageRepository.findById(id);
		if (!language.isPresent())
			throw new LanguageNotFoundException("id-" + id);
		this.languageRepository.deleteById(id);
		this.languageRepository.flush();
		
	}
	
	 /*
	  * deleteAll keyfi sebeplerden dolayi implement edilmemistir
	  */
	 

	

	

}
