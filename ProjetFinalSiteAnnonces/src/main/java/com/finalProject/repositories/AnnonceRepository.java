package com.finalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalProject.entities.Annonce;






@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
	@Query("from Annonce a where a.titreAnnonce =:x" )
	public List<Annonce> findbyName(@Param("x")String nom );
	@Query("from Annonce a where a.titreAnnonce LIKE CONCAT('%',:s,'%') ")/* OR e.nom LIKE CONCAT('%',:s,'%')*/
    public List<Annonce> findbyString(@Param("s") String string); /*pour la barre de recherche*/
	@Query("from Annonce a where a.utilisateur.idUtilisateur =:x" )
	public List<Annonce> findByUser(@Param("x")int idUser );
}
