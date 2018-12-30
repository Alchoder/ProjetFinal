package com.finalProject.services;

import java.util.List;

import com.finalProject.entities.Rubrique;




public interface RubriqueService {


	Boolean createRubrique(Iterable<Rubrique> E);
	Boolean deleteRubrique(int a);
	List<Rubrique> findbyString(String s);
	List<Rubrique> getAllRubrique();
	List<Rubrique> getRubriqueByName(String nom);
	Object getRubriqueById(Integer id) ;
	Boolean deleteManyRubrique(Iterable<Rubrique> Rubs);
	
}
