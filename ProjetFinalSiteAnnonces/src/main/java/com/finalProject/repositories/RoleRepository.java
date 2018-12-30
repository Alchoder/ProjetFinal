package com.finalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalProject.entities.RoleUtilisateur;




@Repository
public interface RoleRepository extends JpaRepository<RoleUtilisateur, Integer> {
	
	
}
