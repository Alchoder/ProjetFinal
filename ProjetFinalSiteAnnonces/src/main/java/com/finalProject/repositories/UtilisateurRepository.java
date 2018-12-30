package com.finalProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finalProject.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	@Query("from Utilisateur u where u.login=:x and u.password=:y")
	public Utilisateur authenticate(@Param("x")String login, @Param("y")String password);
	@Query("from Utilisateur u where u.login=:x")
	public Utilisateur findByName(@Param("x") String login);
}
