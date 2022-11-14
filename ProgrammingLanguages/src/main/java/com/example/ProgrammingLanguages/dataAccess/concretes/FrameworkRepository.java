package com.example.ProgrammingLanguages.dataAccess.concretes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProgrammingLanguages.entities.concretes.Framework;
import com.example.ProgrammingLanguages.entities.concretes.Languages;

public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
//	List<Languages> findAllOrderByIdAsc();  
	 List<Framework> findAllByOrderByIdAsc();    
	 Framework findByName(String name);
	//it is for validation not to save same data twice			
}
