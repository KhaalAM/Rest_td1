package com.inti.Rest_TD1.Test.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.Rest_TD1.Repository.EtudiantRepository;
import com.inti.Rest_TD1.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class) soit ca soit DataJPATest , spring plus lourd
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)


public interface EtudiantRepositoryTest {

	@Autowired
	EtudiantRepository etudiantRepository;
	
	
	@BeforeEach
	public void setup()
	{
		Etudiant e = new Etudiant("Durant","Marc","DM@tests.com","012345678","3");
	}
	
	@Test
	public void testSaveStudents()
	//Given
	
	//When
	{
		Etudiant etudiant = etudiantRepository.save(e);
		//then
		assertThat(saveEtudiant).isNotNull;
	}
	
	
	@Test
	public void testGetAllStudents()
	//Given
	//When
	{
		List<Etudiant>listeEtudiant= etudiantRepository.findAll();
	
		assertThat(listeEtudiant).isNotEmpty();
		assertThat(listeEtudiant).hasSize((int)etudiantRepository.count());//verifie liste meme nb que dans bdd ATTENTION ici on concidere que nous avons deja teste la fonction count pour pouvoir l'utiliser
		
		
		
		
		@Test
		public void testGetAllStudentsLyon()
		//Given
		
		//When
		{
			List<Etudiant>listeEtudiant= etudiantRepository.findByVille();
			//then
			assertThat(listeEtudiant).isNotEmpty();
			assertThat(listeEtudiant.get(0).getEcole().getVille()).isEqualTo("Lyon");
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
