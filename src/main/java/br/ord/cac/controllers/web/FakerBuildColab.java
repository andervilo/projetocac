package br.ord.cac.controllers.web;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import br.ord.cac.DTO.ColaboradorDTO;
import br.ord.cac.services.ServiceColaborador;

@Configuration
public class FakerBuildColab {
	
	@Autowired
	private ServiceColaborador service;
	
	@PostConstruct
	public void makeColaboradores() {
//		Faker faker = new Faker(new Locale("pt-BR"));
//		for(int i = 0; i <= 100; i++ ) {
//			
//			ColaboradorDTO colab = new ColaboradorDTO(
//					faker.leagueOfLegends().champion(), 
//					faker.lorem().sentence(3), 
//					faker.phoneNumber().cellPhone(), 
//					faker.address().zipCode(), 
//					faker.lorem().sentence(3), 
//					faker.lorem().sentence(4), 
//					faker.number().digits(11), 
//					faker.internet().emailAddress(), 
//					faker.address().streetAddress(), 
//					faker.address().streetAddressNumber(), 
//					faker.artist().name(), 
//					faker.job().title());
//			
//			service.create(colab);
//		}
		
		//System.out.println(colab.toString()); 
	}
}
