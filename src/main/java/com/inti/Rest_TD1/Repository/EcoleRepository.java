package com.inti.Rest_TD1.Repository;

import java.util.List;

import com.inti.Rest_TD1.model.Ecole;
import com.inti.Rest_TD1.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EcoleRepository extends JpaRepository<Ecole, Integer> {

	
	public List<Ecole>findAll();
	
	
	
	
	
	
	@Query(value="Select* From ecole Where ville=:'Lyon'",nativeQuery=true)
	public List<Etudiant>findById(@Param("adresse") String adresse);
	
	
	@Query (value"Select p From Professeur p Order By p.salaire)
	public list<Professeur>;
	
	
	
	
	
}
