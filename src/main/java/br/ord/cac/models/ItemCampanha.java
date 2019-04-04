package br.ord.cac.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the item_campanha database table.
 * 
 */
@Entity
@Table(name="item_campanha")
@NamedQuery(name="ItemCampanha.findAll", query="SELECT i FROM ItemCampanha i")
public class ItemCampanha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String nome;

	private BigDecimal valor;

	//bi-directional many-to-one association to Campanha
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="campanha")
	private Campanha campanhaBean;

	//bi-directional many-to-one association to ItemDoacao
	@OneToMany(mappedBy="itemCampanhaBean")
	private List<ItemDoacao> itemDoacaos;

	public ItemCampanha() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<ItemDoacao> getItemDoacaos() {
		return this.itemDoacaos;
	}

	public void setItemDoacaos(List<ItemDoacao> itemDoacaos) {
		this.itemDoacaos = itemDoacaos;
	}

	public ItemDoacao addItemDoacao(ItemDoacao itemDoacao) {
		getItemDoacaos().add(itemDoacao);
		itemDoacao.setItemCampanhaBean(this);

		return itemDoacao;
	}

	public ItemDoacao removeItemDoacao(ItemDoacao itemDoacao) {
		getItemDoacaos().remove(itemDoacao);
		itemDoacao.setItemCampanhaBean(null);

		return itemDoacao;
	}

}