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

import com.finalProject.entities.Rubrique;
import com.finalProject.services.RubriqueService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
@RequestMapping(path = "/gestionRubrique")
public class RubriqueController {

	@Autowired
	RubriqueService RS;

	public RubriqueController() {
		super();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/creation")
	public Boolean addNewEtu(@RequestBody Iterable<Rubrique> E) {
		return RS.createRubrique(E);
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux rubriques
	@GetMapping(value = "/findAll")
	public List<Rubrique> getAllRubriques() {

		return (List<Rubrique>) RS.getAllRubrique();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/delete")
	public Boolean deleteRubrique(@RequestParam int id) {
	System.out.println("Rubrique supprimée");		
		return RS.deleteRubrique(id);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/deleteMany")
	public Boolean deleteManyRubriques(@RequestBody Iterable<Rubrique> Rubs) {
	System.out.println("Rubrique supprimée");		
	
		return RS.deleteManyRubrique(Rubs);
	}
	
	// @PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux rubriques
	@GetMapping(value = "/listByString")
	public List<Rubrique> getRubByString(@RequestParam("s") String string) {

		return (List<Rubrique>) RS.findbyString(string);
	}

}
