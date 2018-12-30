package com.finalProject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entities.RoleUtilisateur;
import com.finalProject.entities.Utilisateur;
import com.finalProject.services.RoleService;
import com.finalProject.services.UtilisateurService;


@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200"})
@RequestMapping(path="/gestionUtilisateur")
public class UtilisateurController {

	
	@Autowired
	UtilisateurService US;
	@Autowired
	RoleService RS;
	
	public UtilisateurController() {
		super();
		
	}
	

	public String EncryptBcrypt(String password) {
		 String  originalPassword = password;
	        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(10));
	        System.out.println(generatedSecuredPasswordHash);
	         
	        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	        System.out.println(matched);
	        return generatedSecuredPasswordHash;
	}
	
//	@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
	
	@PostMapping (value="/adduser")
	public Boolean addNewUser(@RequestBody Utilisateur user) {

		String password = user.getPassword();
	
		user.setPassword(EncryptBcrypt(password));
		
		
		
		RoleUtilisateur role = RS.getRoleUser();
//		RoleUtilisateur role = new RoleUtilisateur("ROLE_USER");		
//		RoleUtilisateur role1 = new RoleUtilisateur("ROLE_ADMIN");

		List<RoleUtilisateur>roles = new ArrayList<>();
		System.out.println("Ca marche ?");
		roles.add(role);
//		roles.add(role1);
		System.out.println("Ca marche ?");
		user.setRoles(roles);
		System.out.println("Ca marche ?");
		US.save(user);
		return true;
		
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/findAllUsers")
	public @ResponseBody Iterable<Utilisateur> getAllUser(){
		return US.findAll();
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value="/deleteUser")
	public Boolean deleteuser (@RequestParam("login") String login) {
		Utilisateur user = US.findByLogin(login);
		US.delete(user);
		return true;
	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value="/findOne")
	@ResponseBody
	public  Utilisateur getUserByLogin(@RequestParam(value="login") String login){
		return US.findByLogin(login);
	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value="/findById")
	@ResponseBody
	public Utilisateur getUserById(@RequestParam(value="idUser") int idUser) {
		return US.findById(idUser);
	}
	
//	@GetMapping(value="/login")
//	public Object login(@RequestParam("uname") String uname, @RequestParam("p") String p) {
//		return US.findByLoginAndPassword(uname, p);
//	}
//	
	
}
