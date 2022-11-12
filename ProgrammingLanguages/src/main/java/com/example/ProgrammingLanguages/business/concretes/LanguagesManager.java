package com.example.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async;
import org.springframework.stereotype.Service;

import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.requests.CreateLanguagesRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguagesRequest;
import com.example.ProgrammingLanguages.business.responses.GetAllLanguagesResponses;
import com.example.ProgrammingLanguages.dataAccess.concretes.LanguagesRepository;
import com.example.ProgrammingLanguages.entities.concretes.Languages;


@Service

public class LanguagesManager implements LanguagesService {

	private LanguagesRepository languageRepository;
	@Autowired
	public LanguagesManager(LanguagesRepository repo) {
		super();
		this.languageRepository=repo;
	}
	@Override
	public List<GetAllLanguagesResponses> getAllResponse() {
		// TODO Auto-generated method stub
		List<Languages> languages=this.languageRepository.findAll();
		//this.languageRepository.flush();
		List<GetAllLanguagesResponses>languageResponse=new ArrayList<>();
		for(Languages language:languages) {
			GetAllLanguagesResponses responseItem=new GetAllLanguagesResponses();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languageResponse.add(responseItem);
		}	
		return languageResponse; 	
		/*List<Brand>brands=brandRepository.findAll();
		List<GetAllBrandResponses>brandsResponse=new ArrayList<>();
		for(Brand brand:brands) {
			GetAllBrandResponses responseItem=new GetAllBrandResponses();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			brandsResponse.add(responseItem);
		}
		return brandsResponse; */
		
	}

	@Override
	public void add(CreateLanguagesRequest createRequest) {
		// TODO Auto-generated method stub
		Languages language=new Languages();
		language.setName(createRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
		
	}
	@Override
	public void update(UpdateLanguagesRequest updateLanguageRequest,int id) {
		// TODO Auto-generated method stub
		Languages language=this.languageRepository.findById(id).get();
		language.setName(updateLanguageRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
		//language=getLanguageById;	
	}
	  
	

	

}
