package com.finalProject.controllers;

import java.util.ArrayList;
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

import com.finalProject.entities.Departement;
import com.finalProject.services.DepartementService;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
@RequestMapping(path = "/gestionDepartement")
public class DepartementController {

	@Autowired
	DepartementService DS;

	public DepartementController() {
		super();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/creation")
	public Boolean addNewEtu(@RequestBody Iterable<Departement> e) {
		return DS.createDepartement(e);
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux départements
	@GetMapping(value = "/findAll")
	public List<Departement> getAllDepartements() {

		return (List<Departement>) DS.getAllDepartement();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/delete")
	public Boolean deleteDepartementById(@RequestBody Departement dpt) {
		System.out.println("Departement supprimée");
		return DS.deleteDepartement(dpt);
	}

	// @PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux départements
	@GetMapping(value = "/listByString")
	public List<Departement> getDptByString(@RequestParam("s") String string) {

		return (List<Departement>) DS.findbyString(string);
	}

}
