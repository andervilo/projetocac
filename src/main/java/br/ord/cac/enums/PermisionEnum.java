package br.ord.cac.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum PermisionEnum {
	CREATE_DOADOR(1, "CREATE_DOADOR"),
	EDIT_DOADOR(2, "EDIT_DOADOR"),
	READ_DOADOR(3, "READ_DOADOR"),
	DELETE_DOADOR(4, "DELETE_DOADOR"),
	CREATE_DOACAO(5, "CREATE_DOACAO"),
	EDIT_DOACAO(6, "EDIT_DOACAO"),
	READ_DOACAO(7, "READ_DOACAO"),
	DELETE_DOACAO(8, "DELETE_DOACAO")
	;
	
	private Integer valor;
	
	private String descricao;	
	
	private PermisionEnum(Integer valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}	
	
	public Integer getValor() {
		return valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static PermisionEnum getById(Integer id) {
		for (PermisionEnum p : PermisionEnum.values()) {
			if(p.getValor()==id)
				return p;
		}
		return null;
	}
	
	public static Map<Object, Object> getByIdFormated(Integer id) {
		Map<Object, Object> per = new HashMap<Object, Object>();
		for (PermisionEnum p : PermisionEnum.values()) {
			if(p.getValor()==id)
				per.put("id", p.getValor());
				per.put("permissao", p.getDescricao());
				return per;
		}
		return null;
	}
	
	public static List<Map<Object, Object>> getList(){
		List<Map<Object, Object>> permisions = new ArrayList<>();		
		
		for (PermisionEnum p : PermisionEnum.values()) {			
			Map<Object, Object> per = new HashMap<Object, Object>();
			per.put("id", p.getValor());
			per.put("permissao", p.getDescricao());
			permisions.add(per);
		}
		return permisions;
		
	}
}

