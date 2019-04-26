package br.ord.cac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.cmeza.sdgenerator.annotation.SDGenerator;

@SDGenerator(
entityPackage = "br.ord.cac.models",
repositoryPackage = "br.ord.cac.repositories",
repositoryPostfix = "Repository",
onlyAnnotations = false,
debug = false,
overwrite = false
)

@SpringBootApplication
@EnableScheduling
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
