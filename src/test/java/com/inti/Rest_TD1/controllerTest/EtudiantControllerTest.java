package com.inti.Rest_TD1.controllerTest;

import static org.hamcrest.CoreMatchers.containsString;

import com.inti.Rest_TD1.Repository.EtudiantRepository;
import com.inti.Rest_TD1.controller.EtudiantController;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = EtudiantController.class )
public class EtudiantControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@Test
	public void testgetAllStudents()
	{
		try {
				mockMvc.perform(get("/students"))	
				.andExpect(status().isOk());
		
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
	
//	try
//	{
//			mockMvc.perform(get("/students"))
//			.andExpect(status().isOk())
//			.andExpect(view().name("etudiants"))
//			.andExpect(content().string(containsString("liste des etudiants")));
//	}
//	
//		
//	{
//		catch (Exception e)
//	}
//	}
//	
		
		@Test
		public void testsaveStudents()
		{
			try {
					mockMvc.perform(post("/saveStudents/{id}","1"))//  1 est la valeur de l'id
					.contentType(MediaType.APPLICATION_JSON)
					
					.andExpect(status().isCreated());
			
			} catch (JsonProcessingException e) {
					// TODO: handle exception
				e.printStackTrace();
			}
		
		
		
		
	}		
		
}
