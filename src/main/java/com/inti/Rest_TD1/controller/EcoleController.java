package com.inti.Rest_TD1.controller;

import java.util.List;

import com.inti.Rest_TD1.Repository.EtudiantRepository;
import com.inti.Rest_TD1.model.Ecole;
import com.inti.Rest_TD1.model.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController {

	
	@Autowired
	EcoleRepository ecoleRepository;
	

	@GetMapping("/school")
	public ResponseEntity<List<Ecole>>getAllSchools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(),HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/saveSchool")
	public ResponseEntity<Ecole> saveSchool(@RequestBody Ecole ecole)
	{
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateSchool/{id}")
	public String updateEcole(@RequestBody Ecole ecole, @PathVariable int id)
	{
	
	
		
		ecoleRepository.save(ecole);
		return "ecole "+ ecole+"a ete mis a jour";
	}
	
	
	
	
	
	@DeleteMapping("/deleteSchool")
	public ResponseEntity<List<Ecole> deleteEcole(@RequestParam("id") int id)
	{
		return new ResponseEntity<Ecole>(ecoleRepository.delete(id),HttpStatus.NO_CONTENT);

	}
	
	
	
	
	
	
	
	
	
}
