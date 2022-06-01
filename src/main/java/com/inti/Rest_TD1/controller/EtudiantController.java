package com.inti.Rest_TD1.controller;

import java.util.List;

import com.inti.Rest_TD1.Repository.EcoleRepository;
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



	import com.inti.TD1Rest.model.Ecole;
	import com.inti.TD1Rest.model.Etudiant;
	import com.inti.TD1Rest.repository.EcoleRepository;
	import com.inti.TD1Rest.repository.EtudiantRepository;

	@RestController
	public class EtudiantController
	{
		@Autowired
		EtudiantRepository etudiantRepository;
		
		@Autowired
		EcoleRepository ecoleRepository;
		
		@GetMapping("/students")
		public ResponseEntity<List<Etudiant>> getAllStudents()
		{
			return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(), HttpStatus.OK);
		}
		
		@PostMapping("/saveStudent")
		public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
		{
			return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant), HttpStatus.CREATED);
		}
		
		@PutMapping("/updateStudent/{id}")
		public String updateStudent(@RequestBody Etudiant etudiant, @PathVariable int id)
		{
			Etudiant e1 = etudiantRepository.getReferenceById(id);
			
			if(!e1.getNom().equals(etudiant.getNom()))
			{
				e1.setNom(etudiant.getNom());
			}
			
			if(!e1.getPrenom().equals(etudiant.getPrenom()) && etudiant.getPrenom() != null)
			{
				e1.setPrenom(etudiant.getPrenom());
			}		
			
			etudiantRepository.save(e1);
			
			return "The student : " + e1 + " has been updated";
		}
		
		@PutMapping("/updateStudentWithSchool/{idEtudiant}/{idEcole}")
		public String updateStudentWithSchool(@RequestBody Etudiant etudiant, @PathVariable int idEtudiant, @PathVariable int idEcole)
		{
			Ecole ecole = ecoleRepository.getReferenceById(idEcole);
			
			etudiant.setEcole(ecole);
			
			etudiantRepository.save(etudiant);
			
			return "The student : " + etudiant + " has been updated";
		}
		
		@DeleteMapping("/deleteStudent")
		public String deleteStudent(@RequestParam("id") int id)
		{
			etudiantRepository.deleteById(id);
			return "Student deleted";
		}
		

	@GetMapping("listStudentBySchool/{idEcole}")
	public ResponseEntity<Lis<Ecole> >listStudentBySchool(@RequestPath Etudiant etudiant)
	{
		return
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
	
	
	@GetMapping("/studentsInLyon")
	public ResponseEntity<List<Etudiant>>getAllStudentsInLyon()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findByVille(),HttpStatus.OK);
	}
	
	
	
}
