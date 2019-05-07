package br.ord.cac.enums;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;

import br.ord.cac.enums.interfaces.IEnumModel;

public enum PermissoesEnum implements IEnumModel<Integer>{
	CADASTRO_COLABORADOR_ACESSO(1,"CADASTRO_COLABORADOR_ACESSO","/colaborador"),
	CADASTRO_COLABORADOR_EDICAO(2,"CADASTRO_COLABORADOR_EDICAO","/colaborador/**");
//	CADASTRO_COLABORADOR_ACESSO(1,"CADASTRO_COLABORADOR_ACESSO","/colaborador"),
//	CADASTRO_COLABORADOR_ACESSO(1,"CADASTRO_COLABORADOR_ACESSO","/colaborador"),
//	CADASTRO_COLABORADOR_ACESSO(1,"CADASTRO_COLABORADOR_ACESSO","/colaborador"),
//	CADASTRO_COLABORADOR_ACESSO(1,"CADASTRO_COLABORADOR_ACESSO","/colaborador"),
	
	private Integer valor;
	private String descricao;
	private String url;
	
	private PermissoesEnum(Integer valor, String descricao, String url) {
		this.valor = valor;
		this.descricao = descricao;
		this.url = url;
	}

	@Override
	public Integer getValor() {
		return valor;
	}

	@Override
	public String getDescricao() {
		return descricao;
	}
	
	public String getUrl() {
		return url;
	}
	
	@Bean
	public static List<PermissoesEnum> listaPermissoes(){
		List<PermissoesEnum> list = new ArrayList<PermissoesEnum>();
		for(PermissoesEnum p : PermissoesEnum.values()) {
			list.add(p);
		}
		return list;
	}
	

}
