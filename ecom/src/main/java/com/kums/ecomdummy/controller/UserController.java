/*package com.kums.ecomdummy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kums.ecomdummy.model.Users;
import com.kums.ecomdummy.service.MyUserDetailService;



@RestController
public class UserController {
	
	@Autowired
	MyUserDetailService service;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(13);
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user){
		user.setPassword(encoder.encode(user.getPassword()));
		return service.register(user);
	}
}
*/