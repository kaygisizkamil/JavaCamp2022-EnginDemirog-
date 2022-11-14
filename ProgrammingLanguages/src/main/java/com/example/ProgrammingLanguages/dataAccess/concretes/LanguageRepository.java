package com.example.ProgrammingLanguages.dataAccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProgrammingLanguages.entities.concretes.Languages;

public interface LanguageRepository extends JpaRepository<Languages,Integer> {
//	List<Languages> findAllOrderByIdAsc();  
	 List<Languages> findAllByOrderByIdAsc();    
	 Languages findByName(String name);
	
	//it is for validation not to save same data twice			
}
