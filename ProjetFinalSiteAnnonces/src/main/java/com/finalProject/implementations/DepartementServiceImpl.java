package com.finalProject.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.entities.Departement;
import com.finalProject.repositories.DepartementRepository;
import com.finalProject.services.DepartementService;



@Service
public class DepartementServiceImpl implements DepartementService{

	@Autowired
	DepartementRepository DR;

	
	public DepartementServiceImpl() {
		super();
	}

	public  Boolean createDepartement (Iterable<Departement> E) {
			DR.saveAll(E);
			return true;		
	
	
	}
	
	public  Boolean deleteDepartement(Departement a) {
		DR.delete(a);
		return true;
	}
	
	public List<Departement> getAllDepartement(){
		return DR.findAll();
	}

	public  Object getDepartementById( Integer id) {
		return DR.findById(id);
	}

	@Override
	public List<Departement> getDepartementByName(String nom) {

		return DR.findbyName(nom);
	}

	@Override
	public List<Departement> findbyString(String s) {
		return DR.findbyString(s);
	}

	

	
}
