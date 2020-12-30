package com.learnProgramming.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyAlienDetailsService implements UserDetailsService {
	
	@Autowired
	private AlienRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AlienDetails alienDetails = repo.findByUsername(username);
		if(alienDetails==null)
			throw new UsernameNotFoundException("Alien Not Found");
		
		return new AlienPrincipal(alienDetails);
	}

}
