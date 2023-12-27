package tn.essat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.config.JwtRequest;
import tn.essat.config.JwtResponse;
import tn.essat.model.User;
import tn.essat.security.GestionToken;
import tn.essat.service.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/auth")

public class RestApp2 {
	
	@Autowired
	UserService users;
	@Autowired
	AuthenticationManager auth;
	
	@Autowired
	GestionToken gest;
	
	@PostMapping("/login")
	public JwtResponse f1(@RequestBody JwtRequest req) {
		
		Authentication auth2 = auth.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())); 
		SecurityContextHolder.getContext().setAuthentication(auth2);
        User user=(User) users.loadUserByUsername(req.getUsername());
        String token = gest.generateToken(user);
        return new JwtResponse(token); 

		
	}

}
