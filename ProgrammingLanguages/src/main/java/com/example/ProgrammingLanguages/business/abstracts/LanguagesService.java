package com.example.ProgrammingLanguages.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;



public interface LanguagesService {
	List<GetLanguageResponse>getAllResponse();
	void add(CreateLanguageRequest createRequest) throws Exception;
	//just to get one language with specified id
	void update(UpdateLanguageRequest updateLanguageRequest, int id)throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest ,int id) throws Exception;
	//GetLanguageByIdResponse getLangugeByIdResponse(int id);
	public GetLanguageResponse getLanguageById(int id) throws Exception;
	//GetByIdLanguageResponse getById(int id);
	//GetLanguageResponse getLangugeById(int id);
	

}
