package com.inti.Rest_TD1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Professeur {
 private int idP;
 private String nom;
 private String prenom;
 private double salaire;
 
 
 public Professeur(String nom, String prenom, double salaire, Professeur professeur) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.salaire = salaire;
	this.professeur = professeur;
}


@ManyToMany
List<Etudiant> listeEtudiant;
 @JoinTable(name="Professeur_Etudiant",
 	joinColumns=@JoinColumn(name="idP"),
 	inverseJoinColumns=@JoinColumn(name="idEco"))

 private Professeur professeur;
 
	
	
	
	
	
	
	
}
