package com.inti.Rest_TD1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Ecole {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEco;
	private String nomEco;
	private String adresse;
	private String cp;
	private String ville;
	
@OneToMany(mappedBy="Ecole",targetEntity = Etudiant.class, cascade = cascadeType.All);
private List<Etudiant>listEtudiant;
	
}
