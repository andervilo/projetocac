package br.ord.cac.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the acao database table.
 * 
 */
@Entity
@NamedQuery(name="Acao.findAll", query="SELECT a FROM Acao a")
public class Acao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date cadastro;

	private int cargaHoraria;

	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fim;

	@Temporal(TemporalType.TIMESTAMP)
	private Date inicio;

	private String nome;

	//bi-directional many-to-many association to Campanha
	@ManyToMany(mappedBy="acaos")
	private List<Campanha> campanhas;

	//bi-directional many-to-many association to Colaborador
	@ManyToMany(mappedBy="acaos")
	private List<Colaborador> colaboradors;

	public Acao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCadastro() {
		return this.cadastro;
	}

	public void setCadastro(Date cadastro) {
		this.cadastro = cadastro;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getFim() {
		return this.fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Campanha> getCampanhas() {
		return this.campanhas;
	}

	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	public List<Colaborador> getColaboradors() {
		return this.colaboradors;
	}

	public void setColaboradors(List<Colaborador> colaboradors) {
		this.colaboradors = colaboradors;
	}

}