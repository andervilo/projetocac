package br.ord.cac.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the item_doacao database table.
 * 
 */
@Entity
@Table(name="item_doacao")
@NamedQuery(name="ItemDoacao.findAll", query="SELECT i FROM ItemDoacao i")
public class ItemDoacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private BigDecimal valor;

	//bi-directional many-to-one association to Campanha
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="campanha")
	private Campanha campanhaBean;

	//bi-directional many-to-one association to Doacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doacao")
	private Doacao doacaoBean;

	//bi-directional many-to-one association to ItemCampanha
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="item_campanha")
	private ItemCampanha itemCampanhaBean;

	public ItemDoacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Campanha getCampanhaBean() {
		return this.campanhaBean;
	}

	public void setCampanhaBean(Campanha campanhaBean) {
		this.campanhaBean = campanhaBean;
	}

	public Doacao getDoacaoBean() {
		return this.doacaoBean;
	}

	public void setDoacaoBean(Doacao doacaoBean) {
		this.doacaoBean = doacaoBean;
	}

	public ItemCampanha getItemCampanhaBean() {
		return this.itemCampanhaBean;
	}

	public void setItemCampanhaBean(ItemCampanha itemCampanhaBean) {
		this.itemCampanhaBean = itemCampanhaBean;
	}

}