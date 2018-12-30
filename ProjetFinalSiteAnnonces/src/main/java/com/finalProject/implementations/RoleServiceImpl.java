package com.finalProject.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.entities.RoleUtilisateur;
import com.finalProject.repositories.RoleRepository;
import com.finalProject.services.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleRepository RR;
	
	@Override
	public RoleUtilisateur getRoleUser() {
		RoleUtilisateur role = RR.getOne(1);
		return role;
	}

}
