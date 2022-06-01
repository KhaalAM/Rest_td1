package com.inti.Rest_TD1.Repository;

import java.util.List;

import com.inti.Rest_TD1.model.Etudiant;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

	
	// Lister tous les étudiants d'une école.
	
	@Query(value ="select * from etudiant where id_Ecole=idEcole,nativeQuery=true")
	 List<Etudiant> findByIdEco(@Param("idEcole") int idEcole);
	

	// Lister tous les étudiants de Lyon
		@Query(value ="select * from etudiant where id_ecole in(\r\n"
			+ "select id from ecole where ville= 'Lyon');")
	 List<Etudiant> findByVille();

//	Etudiant getReferenceById(int id);
}
