package com.finalProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalProject.entities.Departement;





@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer> {
	@Query("from Departement a where a.nomDpt =:x" )
	public List<Departement> findbyName(@Param("x")String nom );
	@Query("from Departement a where a.nomDpt LIKE CONCAT('%',:s,'%') ")/* OR e.nom LIKE CONCAT('%',:s,'%')*/
    public List<Departement> findbyString(@Param("s") String string); /*pour la barre de recherche*/
	
}
