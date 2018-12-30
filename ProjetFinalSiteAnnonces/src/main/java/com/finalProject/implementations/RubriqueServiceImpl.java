package com.finalProject.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.entities.Rubrique;
import com.finalProject.repositories.RubriqueRepository;
import com.finalProject.services.RubriqueService;

@Service
public class RubriqueServiceImpl implements RubriqueService {

	@Autowired
	RubriqueRepository RR;

	public RubriqueServiceImpl() {
		super();
	}

	public Boolean createRubrique(Iterable<Rubrique> E) {
		RR.saveAll(E);
		return true;
	}

	public Boolean deleteRubrique(int a) {
		RR.deleteById(a);
		return true;
	}
	public Boolean deleteManyRubrique(Iterable<Rubrique> a) {		
		RR.deleteAll(a);
		return true;
	}
	public List<Rubrique> getAllRubrique() {
		return RR.findAll();
	}

	public Object getRubriqueById(Integer id) {
		return RR.findById(id);
	}

	@Override
	public List<Rubrique> getRubriqueByName(String nom) {

		return RR.findbyName(nom);
	}

	@Override
	public List<Rubrique> findbyString(String s) {
		return RR.findbyString(s);
	}

}
