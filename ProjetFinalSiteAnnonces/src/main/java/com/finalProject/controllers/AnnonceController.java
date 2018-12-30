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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entities.Annonce;

import com.finalProject.services.AnnonceService;



@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200"})
@RequestMapping(path = "/gestionAnnonces")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	
	
	public AnnonceController() {
		super();
		
	}
	

	
	@PreAuthorize("hasRole('ROLE_USER')") 
	@PostMapping(value = "/creation"/*, method = RequestMethod.POST*/)
	

	public Boolean addNewAnnonce(@RequestBody Annonce E) {
		return annonceService.createAnnonce(E);
		

	}
//	@PreAuthorize("hasRole('ROLE_USER')") 
//	@PostMapping(value = "/modification")
//	
//
//	public Boolean modifAnnonce(@RequestBody Annonce E,@RequestParam ("id") int id) {
//		
//		annonceService.updateAnnonce(E);
//		return true;
//
//	}
//	@PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux annonces
	@GetMapping(value = "/findAll")
	public List<Annonce> getAllAnnonces() {

		return (List<Annonce>)annonceService.getAllAnnonce();
	}
	@PreAuthorize("hasRole('ROLE_USER')") 
	@DeleteMapping(value = "/delete")
	public Boolean deleteAnnonce(@RequestParam("id") int id) {
		System.out.println("annonce supprimée");
		return annonceService.deleteAnnonce(id);
	
		
	}
	@PreAuthorize("hasRole('ROLE_USER')") 
	@RequestMapping(value = "/TheChosenOne", method = RequestMethod.GET)

	public Object getEtuByID(@RequestParam("id") int id) {

		return annonceService.getAnnonceById(id);
	}
//	@PreAuthorize("hasRole('ROLE_ADMIN')") 
//	@GetMapping(value = "/listByName")
//	public List<Annonce> getEtusByName(@RequestParam("nom")String nom) {
//
//		return (List<Annonce>)annonceService.getEtuByName(nom);
//	}
	@PreAuthorize("hasRole('ROLE_USER')") 
	@GetMapping(value = "/listByUser")
	public List<Annonce> getAnnByUser(@RequestParam("idUser") int idUser ) {

		return (List<Annonce>)annonceService.getAnnByUser(idUser);
	}
	
//	@PreAuthorize("hasRole('ROLE_ADMIN')") tout le monde a accès aux annonces
	@GetMapping(value = "/listByString")
	public List<Annonce> getAnnByString(@RequestParam("s")String string) {

		return (List<Annonce>)annonceService.findbyString(string);
	}
	
}
