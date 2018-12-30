package com.finalProject.services;

import java.util.List;

import com.finalProject.entities.Utilisateur;




public interface UtilisateurService {
	public Utilisateur findByLoginAndPassword(String login, String password);
	public Utilisateur findByLogin(String login);
	public Utilisateur save(Utilisateur utilisateur);
	public List<Utilisateur> findAll();
	public void delete(Utilisateur utilisateur);
	public Utilisateur findById(int idUser);
	
}
