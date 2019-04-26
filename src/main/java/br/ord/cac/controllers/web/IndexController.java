package br.ord.cac.controllers.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ord.cac.services.ServiceColaborador;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
//@RequestMapping("/api/v1/colaboradores")
public class IndexController  {
	
	@Autowired
	private ServiceColaborador serviceColaborador;
	
	private String teste;	
	
	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

	@GetMapping("")
	public String index1() {
		
		return "base/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String index2() {
		
		return "base/dashboard";
	}
	
	@GetMapping("/")
	public String index3() {
		
		return "base/dashboard";
	}
	
	@GetMapping("/acoes")
	public String acoes() {
		
		return "datatables";
	}
	
	@GetMapping("/campanhas")
	public String campanhas() {
		
		return "datatables";
	}
	
	@GetMapping("/colaboradores")
	public String colaboradores() {
		
		return "colaboradores/list";
	}
	
	@GetMapping("/colaboradores/novo")
	public String colaboradoresNovo() {
		return "colaboradores/create";
	}
	
	@GetMapping("/doacoes")
	public String doacoes() {
		
		return "datatables";
	}
	
	@GetMapping("/colaboradores/teste")
	public String teste(Model model, @PageableDefault(value = 10) Pageable pageable) {

		model.addAttribute("teste", new String("String de teste"));
		model.addAttribute("colaboradores", serviceColaborador.findAll(pageable));
		return "colaboradores/teste";
	}
	
	@GetMapping("/minharota")
	public String minharota(Model model) {
		return "teste";
	}
	
	@GetMapping("/ajax")
    public String loadContent() {
        return "ajax/website";
    }

	@PostMapping("/ajax/content1")
    public String getContent1(Model model) {
		setTeste("Conteúdo 1");
		model.addAttribute("attr1", getTeste());
        return "ajax/content :: content1";
    }

	@PostMapping("/ajax/content2")
    public String getContent2(Model model) {
		setTeste("Conteúdo 2");
		model.addAttribute("attr2", getTeste());
        return "ajax/content :: content2";
    }
	
}
