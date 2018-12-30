package com.finalProject.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.finalProject.entities.Utilisateur;
import com.finalProject.services.UtilisateurService;



@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	UtilisateurService utilisateurService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Utilisateur UM = utilisateurService.findByLogin(username);
		if (UM == null) throw new UsernameNotFoundException (username);
		List<GrantedAuthority> authorities= new ArrayList<>();
		UM.getRoles().forEach(role-> {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		});
		return (UserDetails) new User(UM.getLogin(), UM.getPassword(), authorities);
	}
}
