package br.org.cac.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.org.cac.enums.PerfilEnum;
import br.org.cac.models.User;
import br.org.cac.repositories.UserRepository;

@Controller
public class UtilsController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/403")
	public String erro403(Model model) {
		
		return "403";
	}
	
	@GetMapping("/404")
	public String erro404(Model model) {
		
		return "404";
	}
	
	@GetMapping("/500")
	public String erro500(Model model) {
		
		return "500";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		if(this.repository.findByUsername("admin") == null) {			
			User user = new User();
			user.setUsername("admin");
			user.setColaborador(null);
			user.setRole(PerfilEnum.ADMINISTRADOR);
			user.setPassword(passwordEncoder.encode("123456"));
			this.repository.saveAndFlush(user);
			System.out.println("usuário criado!");
	}
		
		return "login";
	}
}
