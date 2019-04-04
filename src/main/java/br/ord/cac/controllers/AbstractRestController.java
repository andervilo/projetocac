package br.ord.cac.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

public abstract class AbstractRestController <T, 
		R extends JpaRepository<T, Integer>> implements IApiController<T> {
	
	@Autowired
	private R repository;	
	
	@GetMapping("")
	@Override
	public ResponseEntity<List<T>> getAll() {		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	@Override
	public ResponseEntity<T> getById(@PathVariable(value = "id") Integer id) {
		T entity = (T) repository.findById(id);
		
		if(entity == null) {
			return ResponseEntity.notFound().build();
		}
			
		
		return ResponseEntity.ok().body(entity);
	}
	
//	@PostMapping("")
//	@Override
	public ResponseEntity<T> create(@Valid T entity) {	
		
		return ResponseEntity.ok().body(repository.save(entity));
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/{id}")
	@Override
	public ResponseEntity<T> update(@PathVariable(value = "id") Integer id, @Valid T entityUpdate) {
		T entity = (T) repository.findById(id);
		
		if(entity == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(entityUpdate, entity, "id");
		
		return ResponseEntity.ok().body(repository.save(entity));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(@PathVariable(value = "id") Integer id) {
		T entity = (T) repository.findById(id);
		
		if(entity != null) {
			repository.delete(entity);
		}
	}

}
