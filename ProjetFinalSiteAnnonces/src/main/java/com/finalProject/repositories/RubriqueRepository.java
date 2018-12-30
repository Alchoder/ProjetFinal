package com.finalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalProject.entities.Rubrique;





@Repository
public interface RubriqueRepository extends JpaRepository<Rubrique, Integer> {
	@Query("from Rubrique a where a.titreRubrique =:x" )
	public List<Rubrique> findbyName(@Param("x")String nom );
	@Query("from Rubrique a where a.titreRubrique LIKE CONCAT('%',:s,'%') ")/* OR e.nom LIKE CONCAT('%',:s,'%')*/
    public List<Rubrique> findbyString(@Param("s") String string); /*pour la barre de recherche*/
	
}
