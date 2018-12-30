package com.finalProject.services;

import java.util.List;

import com.finalProject.entities.Departement;




public interface DepartementService {


	Boolean createDepartement(Iterable<Departement> e);
	Boolean deleteDepartement(Departement a);
	List<Departement> findbyString(String s);
	List<Departement> getAllDepartement();
	List<Departement> getDepartementByName(String nom);
	Object getDepartementById(Integer id) ;
	
}
