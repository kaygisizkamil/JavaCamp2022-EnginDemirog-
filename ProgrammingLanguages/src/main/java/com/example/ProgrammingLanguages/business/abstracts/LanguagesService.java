package com.example.ProgrammingLanguages.business.abstracts;

import java.util.List;

import com.example.ProgrammingLanguages.business.requests.CreateLanguagesRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguagesRequest;
import com.example.ProgrammingLanguages.business.responses.GetAllLanguagesResponses;


public interface LanguagesService {
	List<GetAllLanguagesResponses>getAllResponse();
	void add(CreateLanguagesRequest createRequest);
	//just to get one language with specified id
	void update(UpdateLanguagesRequest updateLanguageRequest,int id);
}
