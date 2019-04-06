package br.ord.cac.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
//@RequestMapping("/api/v1/colaboradores")
public class IndexController  {
	
	@GetMapping("")
	public String index() {
		
		return "datatables";
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
	
}
