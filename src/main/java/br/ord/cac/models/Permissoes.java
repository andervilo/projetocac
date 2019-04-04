package br.ord.cac.models;

import java.util.ArrayList;
import java.util.List;

import br.ord.cac.enums.PermisionEnum;

public class Permissoes {
	
	public class Permissao{
		private Integer id;
		private String permissao;
				
		public Permissao(Integer id, String permissao) {
			this.id = id;
			this.permissao = permissao;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getPermissao() {
			return permissao;
		}
		public void setPermissao(String permissao) {
			this.permissao = permissao;
		}
		
		
	}

	public List<Permissao> getPermissoes(){
		List<Permissao> list = new ArrayList<>();
		for (PermisionEnum p : PermisionEnum.values()) {
			list.add(new Permissao(p.getValor(), p.getDescricao()));			
		}
		return list;
	}
}
