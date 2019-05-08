package br.ord.cac.controllers.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ord.cac.enums.PorPaginaEnum;
import br.ord.cac.models.Colaborador;
import br.ord.cac.repositories.ColaboradorRepository;


@Controller
@RequestMapping("/colaboradores")
public class ColaboradorController {
	@Autowired
	private ColaboradorRepository repository;
	
	private Colaborador VO = new Colaborador();
	
	private Integer page = 0;
	private Integer size = 0;
	private List<Colaborador> colabList;
	private Page<Colaborador> colabPage;
	private String buscaNome = "";
	private List<PorPaginaEnum> porPagina;
	

	public Colaborador getVO() {
		return VO;
	}

	public void setVO(Colaborador vO) {
		VO = vO;
	}
	
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

	public List<Colaborador> getColabList() {
		return colabList;
	}

	public void setColabList(List<Colaborador> colabList) {
		this.colabList = colabList;
	}
	
	public void teste() {
		System.out.println("page: "+page+" size: "+size);
	}	

	public Page<Colaborador> getColabPage() {
		return colabPage;
	}	

	public void setColabPage(Page<Colaborador> colabPage) {
		this.colabPage = colabPage;
	}

	public String getBuscaNome() {
		return buscaNome;
	}

	public void setBuscaNome(String buscaNome) {
		this.buscaNome = buscaNome;
	}
	
	public List<PorPaginaEnum> getPorPagina(){
		porPagina = new ArrayList<PorPaginaEnum>();
		porPagina.addAll(Arrays.asList(PorPaginaEnum.values()));
		return porPagina;
	}

	/**
	 * Comportamentos
	 */
	
	public Integer getPaginaAtual() {
		return getColabPage().getNumber() + 1;
	}
	
	@PostMapping("/proximo")
	public String proximo() {
		if(colabPage.hasNext()) {
			colabPage = repository.findByNomeContainingOrEmailContainingOrCelularContaining(buscaNome, buscaNome, buscaNome, colabPage.nextPageable());;
			setColabList(colabPage.getContent());
		}
		
		return "redirect:/colaboradores";
	}
	
	@PostMapping("/anterior")
	public String anterior() {
		if(colabPage.hasPrevious()) {
			colabPage = repository.findByNomeContainingOrEmailContainingOrCelularContaining(buscaNome, buscaNome, buscaNome, colabPage.previousPageable());
			setColabList(colabPage.getContent());
		}
		
		return "redirect:/colaboradores";
	}
	
	@PostMapping("/buscarpor")
	public String buscarpor(@RequestParam("busca") Optional<String> busca, 
			@RequestParam("size") Optional<Integer> sizeBusca) {
		
		if(busca.isPresent()) {
			if(sizeBusca.isPresent()) {
				setSize(sizeBusca.get());
			}
				
			setBuscaNome(busca.get());
			Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
			colabPage = repository.findByNomeContainingOrEmailContainingOrCelularContaining(buscaNome, buscaNome, buscaNome, pageable);
			setColabList(colabPage.getContent());
		}
		
		return "redirect:/colaboradores";
	}
	
	@PostMapping("/resetabusca")
	public String resetabusca() {
		setBuscaNome("");
		initListColaborador();
		return "redirect:/colaboradores";
	}
	
	
	
	@PostConstruct
	public void initListColaborador(){
		setSize(5);
		Pageable pageable = PageRequest.of(page, size, new Sort(Direction.DESC, "id"));
		colabPage = repository.findByNomeContainingOrEmailContainingOrCelularContaining(buscaNome, buscaNome, buscaNome, pageable);
		setBuscaNome("");
		setColabList(colabPage.getContent());
	}
	
	@GetMapping
	public String listColaborador(Model model){
		model.addAttribute("colaboradores", getColabList());
		model.addAttribute("page", getColabPage());
		model.addAttribute("busca", getBuscaNome());
		model.addAttribute("porPagina", getPorPagina());
		model.addAttribute("size", getSize());
		return "colaboradores/list";
	}
	
	
	public void save() {
		repository.saveAndFlush(getVO());
		setVO(new Colaborador());
		Pageable pageable = PageRequest.of(colabPage.getNumber(), colabPage.getSize(), new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);		
		setColabList(colabPage.getContent());
	}
	
	public void delete() {
		repository.delete(getVO());
		setVO(new Colaborador());
		Pageable pageable = PageRequest.of(colabPage.getNumber(), colabPage.getSize(), new Sort(Direction.DESC, "id"));
		colabPage = repository.findAll(pageable);		
		setColabList(colabPage.getContent());
	}
	
	public void editar(Colaborador colaborador) {
		//System.out.println(getVO().getNome());
		//repository.delete(getVO());
		setVO(colaborador);
		//return null;
	}
	
	public void limpar() {
		setVO(null);
	}
}
