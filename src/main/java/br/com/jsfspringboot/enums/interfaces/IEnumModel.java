package br.com.jsfspringboot.enums.interfaces;

import java.io.Serializable;

public interface IEnumModel<T extends Serializable> {

	T getValor();

	String getDescricao();

}