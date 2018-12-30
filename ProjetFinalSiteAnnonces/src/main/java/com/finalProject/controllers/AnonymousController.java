package com.finalProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entities.Annonce;
import com.finalProject.entities.Departement;
import com.finalProject.entities.Rubrique;
import com.finalProject.services.AnnonceService;
import com.finalProject.services.DepartementService;
import com.finalProject.services.RubriqueService;



@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200"})
@RequestMapping(path = "/getList")
public class AnonymousController {

	@Autowired
	AnnonceService annonceService;
	@Autowired
	DepartementService DS;
	@Autowired
	RubriqueService RS;
	
	public AnonymousController() {
		super();
		
	}
	

	
	@GetMapping(value = "/findAllAnnonce")	
	public List<Annonce> getAllAnnonces() {

		return (List<Annonce>)annonceService.getAllAnnonce();
	}

	@GetMapping(value = "/listAnnonceByString")
	public List<Annonce> getAnnByString(@RequestParam("s")String string) {

		return (List<Annonce>)annonceService.findbyString(string);
	}
	@GetMapping(value = "/listDptByString")
	public List<Departement> getDptByString(@RequestParam("s") String string) {

		return (List<Departement>) DS.findbyString(string);
	}
	@GetMapping(value = "/findAllDpt")
	public List<Departement> getAllDepartements() {

		return (List<Departement>) DS.getAllDepartement();
	}
	@GetMapping(value = "/findAllRub")
	public List<Rubrique> getAllRubriques() {

		return (List<Rubrique>) RS.getAllRubrique();
	}
	@GetMapping(value = "/listRubByString")
	public List<Rubrique> getRubByString(@RequestParam("s") String string) {

		return (List<Rubrique>) RS.findbyString(string);
	}
}
