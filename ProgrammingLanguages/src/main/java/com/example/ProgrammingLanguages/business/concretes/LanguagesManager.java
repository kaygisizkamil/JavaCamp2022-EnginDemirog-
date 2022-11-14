package com.example.ProgrammingLanguages.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ProgrammingLanguages.business.abstracts.LanguagesService;
import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;
import com.example.ProgrammingLanguages.dataAccess.concretes.LanguageRepository;
import com.example.ProgrammingLanguages.entities.concretes.Languages;


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

	@Override
	public GetLanguageResponse getLanguageById(int id) {
		Languages language=this.languageRepository.findById(id).get();
		GetLanguageResponse response=new GetLanguageResponse();
		response.setId(language.getId());
		response.setName(language.getName());
		return response;
	}
	@Override
	public void add(CreateLanguageRequest createRequest) throws Exception {
		// TODO Auto-generated method stub
		 IsValid(createRequest.getName());
		Languages language=new Languages();
		language.setName(createRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
		
	}
	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception {
		// TODO Auto-generated method stub
		 IsValid(updateLanguageRequest.getName());
		Languages language=this.languageRepository.findById(id).get();
		language.setName(updateLanguageRequest.getName());
		this.languageRepository.save(language);
		this.languageRepository.flush();
		//language=getLanguageById;	
	}
	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest, int id) throws Exception {
		IsExist(id);
		Languages language=this.languageRepository.findById(id).get();
		this.languageRepository.deleteById(id);
		this.languageRepository.flush();
		
	}
	 private void IsValid(String name) throws Exception {
	        Languages isExist= this.languageRepository.findByName(name);
	        if (isExist!=null){
	            throw new Exception("Name already exists");
	        }
	 }
	 private void IsExist(int id)throws Exception{
		 	if(this.languageRepository.findById(id).isPresent()) {
		 		throw new Exception("Kayıtlı language bulunamadi");
		 	}
	 }
	 

	

	

}
