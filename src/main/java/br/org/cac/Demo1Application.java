package br.org.cac;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.org.cac.enums.PerfilEnum;
import br.org.cac.models.User;
import br.org.cac.repositories.UserRepository;

//@SDGenerator(
//entityPackage = "br.org.cac.models",
//repositoryPackage = "br.org.cac.repositories",
//repositoryPostfix = "Repository",
//onlyAnnotations = false,
//debug = false,
//overwrite = false
//)

@SpringBootApplication
@EnableScheduling
public class Demo1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
	
	@PostConstruct
	void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	
	
	@PostConstruct
	void createUser() {
		
		
	}

}
