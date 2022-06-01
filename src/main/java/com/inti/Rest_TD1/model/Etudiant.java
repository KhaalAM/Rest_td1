package com.inti.Rest_TD1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String anneeEtude;
	
	@ManyToOne
	@JoinColumn(name="id",nullable=false)
	private Etudiant etudiant;
	
	@ManyToMany
	List<Professeur> listeProfesseur;
	
	@JoinTable(name="Professeur_Etudiant",
	 	joinColumns=@JoinColumn(name="idP"),
	 	inverseJoinColumns=@JoinColumn(name="idEcole"))
	
	
	
	
	
}
