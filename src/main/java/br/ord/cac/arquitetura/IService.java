package br.ord.cac.arquitetura;

import java.util.List;

import br.ord.cac.arquitetura.IDTO;


public interface IService<E, T extends IDTO > {
		
	public abstract List<?> findAll();
	
	public abstract IDTO findById(Integer id);
	
	public abstract T create(T object);
	
	public abstract T update(Integer id, T object);
	
	public abstract boolean delete(Integer id);	

}
