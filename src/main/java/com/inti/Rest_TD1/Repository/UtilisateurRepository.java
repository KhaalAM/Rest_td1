package com.inti.Rest_TD1.Repository;

import java.util.List;


import com.inti.Rest_TD1.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository <Utilisateur, Integer> {

	
	
	public List<Utilisateur> findAll();
	
	
	
	
	
	
	
}
