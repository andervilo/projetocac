package br.ord.cac.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface IApiController<E> {
		
	public ResponseEntity<List<E>> getAll();
	
	public ResponseEntity<E> getById(@PathVariable(value = "id") Integer id);
	
	public ResponseEntity<E> create(@Valid @RequestBody E object);
	
	public ResponseEntity<E> update(@PathVariable(value = "id") Integer id, @Valid @RequestBody E object);
	
	public void delete(@PathVariable(value = "id") Integer id);

}
