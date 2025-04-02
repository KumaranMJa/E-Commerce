/*package com.kums.ecomdummy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kums.ecomdummy.model.UserPrincipal;
import com.kums.ecomdummy.model.Users;
import com.kums.ecomdummy.repo.UsersRepo;


@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsersRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findByUsername(username);
		if(user == null) {
			System.out.println("User Not Found");
			 throw new UsernameNotFoundException ("User Not Found");
		}
		
		return new UserPrincipal(user);
	}

	public Users register(Users user) {
		return repo.save(user);
	}
}
*/