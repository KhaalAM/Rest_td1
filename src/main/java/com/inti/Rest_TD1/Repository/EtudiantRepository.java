package com.inti.Rest_TD1.Repository;

import java.util.List;

import com.inti.Rest_TD1.model.Etudiant;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {


	public List<Etudiant> findAll();
	
	findByEmail
}
