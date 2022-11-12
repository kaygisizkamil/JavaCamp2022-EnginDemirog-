package com.example.ProgrammingLanguages.dataAccess.concretes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProgrammingLanguages.entities.concretes.Languages;

public interface LanguagesRepository extends JpaRepository<Languages,Integer> {
				
}
