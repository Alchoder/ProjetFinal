package com.finalProject.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.entities.Annonce;

import com.finalProject.repositories.AnnonceRepository;
import com.finalProject.services.AnnonceService;



@Service
public class AnnonceServiceImpl implements AnnonceService{

	@Autowired
	AnnonceRepository AR;

	
	public AnnonceServiceImpl() {
		super();
	}

	public  Boolean createAnnonce (Annonce E) {
//		String tel = E.getTelephone();
//		
//		if (tel.length() == 10 && tel.charAt(0)=='0')
//		{
//			for (int i=0; i<10 ;i++){
//				if (!Character.isDigit((tel.charAt(i))))
//					return false;
//			}
			AR.save(E);
			return true;
//		}
//		return false;
//		
	
		
	}
	public void updateAnnonce(Annonce E) {
		
		
		AR.save(E);
	}
		
	public  Boolean deleteAnnonce(int a) {
		AR.deleteById(a);
		return true;
	}
	
	public List<Annonce> getAllAnnonce(){
		return AR.findAll();
	}

	public  Object getAnnonceById( Integer id) {
		return AR.findById(id);
	}

	@Override
	public List<Annonce> getAnnonceByName(String nom) {

		return AR.findbyName(nom);
	}

	@Override
	public List<Annonce> findbyString(String s) {
		return AR.findbyString(s);
	}

	@Override
	public List<Annonce> getAnnByUser(int idUser) {

		return AR.findByUser(idUser);
	}

	
}
