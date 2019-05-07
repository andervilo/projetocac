package br.ord.cac.enums;

import br.ord.cac.enums.interfaces.IEnumModel;


public enum TipoPessoaEnum implements IEnumModel<String> {
	FISICA("F", "Física"),
	JURIDICA("J", "Jurídica");

	private String valor;

	private String descricao;

	private TipoPessoaEnum(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	@Override
	public String getDescricao() {
		return this.descricao;
	}

	@Override
	public String getValor() {
		return this.valor;
	}

}
