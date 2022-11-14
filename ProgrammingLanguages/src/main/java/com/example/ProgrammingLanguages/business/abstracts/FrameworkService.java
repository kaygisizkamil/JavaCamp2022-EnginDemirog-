package com.example.ProgrammingLanguages.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.ProgrammingLanguages.business.requests.CreateFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.CreateLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.DeleteLanguageRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateFrameworkRequest;
import com.example.ProgrammingLanguages.business.requests.UpdateLanguageRequest;
import com.example.ProgrammingLanguages.business.responses.GetFrameworkResponse;
import com.example.ProgrammingLanguages.business.responses.GetLanguageResponse;


public interface FrameworkService {
	List<GetFrameworkResponse>getAllResponse();
	void add(CreateFrameworkRequest createRequest) ;
	//just to get one language with specified id
	void update(UpdateFrameworkRequest updateFrameworkRequest, int id);
	void delete(DeleteFrameworkRequest deleteFrameworkRequest ,int id);
   public GetFrameworkResponse getById(int id);
}
