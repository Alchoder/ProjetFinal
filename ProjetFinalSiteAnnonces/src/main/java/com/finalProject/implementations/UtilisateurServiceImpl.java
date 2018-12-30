package com.finalProject.implementations;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.entities.Utilisateur;
import com.finalProject.repositories.UtilisateurRepository;
import com.finalProject.services.UtilisateurService;





@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	UtilisateurRepository UR;
	
	@Override
	public Utilisateur findByLoginAndPassword(String login, String password) {
		
		return UR.authenticate(login, password);
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return UR.findByName(login);
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		
		return UR.save(utilisateur);
	}

	@Override
	public List<Utilisateur> findAll() {

		return UR.findAll();
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		UR.delete(utilisateur);
		
	}

	@Override
	public Utilisateur findById(int idUser) {
		return  UR.getOne(idUser);
	}

}
