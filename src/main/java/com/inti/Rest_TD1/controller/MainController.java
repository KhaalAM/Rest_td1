package com.inti.Rest_TD1.controller;

import java.util.List;

import com.inti.Rest_TD1.Repository.UtilisateurRepository;
import com.inti.Rest_TD1.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@GetMapping("/hello")// on precise URL
	public String hello()
	{
		return "Hello World" ;// on ne retourne plus de page html/jsp mais le doc JSON ici c'est un message qui s'affiche
	}
	
	
	@RequestMapping(value = "/users", method=RequestMethod.GET)
			public List<Utilisateur> getAllUsers()
			{
			return utilisateurRepository.findAll();
			}
	
	
	@PostMapping("save")
	public String saveUser()
	{
		Utilisateur u = new Utilisateur("login","login");
		utilisateurRepository.save(u);
		return "user saved";
	}
	
}
