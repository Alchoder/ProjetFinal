package com.finalProject.services;

import java.util.List;

import com.finalProject.entities.Annonce;




public interface AnnonceService {


	Boolean createAnnonce (Annonce E);
	void updateAnnonce (Annonce E);
	Boolean deleteAnnonce(int a);
	List<Annonce> findbyString(String s);
	List<Annonce> getAllAnnonce();
	List<Annonce> getAnnonceByName(String nom);
	Object getAnnonceById(Integer id) ;
	List<Annonce> getAnnByUser(int idUser);
	
}
