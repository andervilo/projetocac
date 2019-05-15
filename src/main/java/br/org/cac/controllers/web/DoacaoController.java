package br.org.cac.controllers.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.org.cac.enums.PorPaginaEnum;
import br.org.cac.models.Doacao;
import br.org.cac.repositories.DoacaoRepository;;

@Controller
@RequestMapping("/doacoes")
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository repository;
	
	private Integer page = 0;
	private Integer size = 0;
	private List<Doacao> doacaoList;
	private Page<Doacao> doacaoPage;
	private String busca = "";
	private List<PorPaginaEnum> porPagina;
	private Date cadastro;
	
	@GetMapping
	public String list(Model model) {
		
		return "doacoes/list";
	}
	
	@GetMapping("/{id}/show")
	public String show(@PathVariable int id, Model model) {
		if(repository.findById(id).isPresent()) {
			model.addAttribute("colaborador", repository.findById(id).get());				
			return "doacoes/show";
		}
		initList();
		return "redirect:/doacoes";
	}
	
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable int id, Model model) {
		if(repository.findById(id).isPresent()) {
			model.addAttribute("doacao", repository.findById(id).get());				
			return "doacao/edit";
		}
		initList();
		return "redirect:/doacoes/";
	}
	
	@PostMapping("/{id}/salvar")
	public String salvar(@PathVariable int id, Model model, @ModelAttribute @Valid Doacao doacao) {
		if(repository.findById(id).isPresent()) {
			try {
				repository.saveAndFlush(doacao);
			} catch (Exception e) {
				System.out.println("Erro ao alterar Doação: "+e.getMessage());
			}				
			return "redirect:/doacoes/"+id+"/show";
		}
		initList();
		return "redirect:/doacoes/";
	}
	
	@PostMapping("/salvar")
	public String salvarAlteracao(@ModelAttribute @Valid Doacao doacao, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
            return "doacoes/create";
        }else {
			try {
				repository.saveAndFlush(doacao);
			} catch (Exception e) {
				System.out.println("Erro ao salvar Doacão: "+e.getMessage());
			}
			initList();
			return "redirect:/doacoes/";
        }
	}
	
	@GetMapping("/novo")
	public String novo(Model model) {
		model.addAttribute("doacao", new Doacao());		
		return "doacao/create";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			initList();			
		}
		return "redirect:/colaboradores";
	}
	
	/**
	 * Comportamentos
	 */
	@PostConstruct
	public void initList(){
		setSize(5);
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		this.doacaoPage = repository.findByColaboradorNomeContainingOrCadastro(busca, cadastro, pageable);
		setBusca("");
		setDoacaoList(getDoacaoPage().getContent());
	}
		
	/**
	 * GETTERS/SETTERS
	 */
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<Doacao> getDoacaoList() {
		return doacaoList;
	}

	public void setDoacaoList(List<Doacao> doacaoList) {
		this.doacaoList = doacaoList;
	}

	public Page<Doacao> getDoacaoPage() {
		return doacaoPage;
	}

	public void setDoacaoPage(Page<Doacao> doacaoPage) {
		this.doacaoPage = doacaoPage;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public List<PorPaginaEnum> getPorPagina() {
		return porPagina;
	}

	public void setPorPagina(List<PorPaginaEnum> porPagina) {
		this.porPagina = porPagina;
	}
	
	public Date getCadastro() {
		return cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}
	
	

}
