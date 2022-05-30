package com.inti.Rest_TD1.controller;

import java.util.List;

import com.inti.Rest_TD1.Repository.EtudiantRepository;
import com.inti.Rest_TD1.model.Etudiant;
import com.inti.Rest_TD1.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController {

	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	Etudiant etudiant;
	
	@GetMapping("/test")
	public String hello()
	{
		return "Hello World";
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Etudiant>>getAllStudent()
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.findAll(),HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("saveEtudiant")
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant),HttpStatus.CREATED);
	}
	
	
	@PutMapping("updateEtudiant/{id}")
	public String updateEtudiant(@RequestBody Etudiant etudiant, @PathVariable int id)
	{
		Etudiant e1 = etudiantRepository.getById(id);
	if (!e1.getNom().equals(etudiant).getNom())
	{
		e1.setNom(etudiant.getNom());
	}
		
	if (!e1.getPrenom().equals(etudiant.getPrenom())&& etudiant.getPrenom()!=null)
	{
		e1.setPrenom(etudiant.getPrenom());
	}
	
		
		etudiantRepository.save(etudiant);
		return "etudiant "+ etudiant+"a ete mis a jour";
	}
	
	
	
	
	
	@DeleteMapping("/deleteEtudiant")
	public ResponseEntity<List<Etudiant> deleteEtudiant(@RequestParam("id") int id)
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.delete(id),HttpStatus.NO_CONTENT);

	}
	
	
//	@RequestMapping(value="/Etudiants", method=RequestMethod.GET)
//	public List<Etudiant> getAll
//	
//	
//	
//	@PostMapping("save")
//	public String saveEtudiant()
//	{
//		Etudiant e = new Etudiant();
//		etudiantRepository.save(e);
//		return "etudiant sauvegardé";
//	}
//	
//	
//	@PostMapping("delete")
//	public String deleteEtudiant()
//	{
//		
//		etudiantRepository.delete(e);
//		return "etudiant supprimé";
	}
	
	
	
	
	
	
}
