package br.ord.cac.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.ord.cac.arquitetura.IDTO;
import br.ord.cac.models.Colaborador;


public class ColaboradorDTO extends Colaborador implements IDTO {

	private static final long serialVersionUID = -7018017070949760754L;
	
	@JsonIgnore
	@Override
	public String getSenha() {
		return super.getSenha();
	}

}
