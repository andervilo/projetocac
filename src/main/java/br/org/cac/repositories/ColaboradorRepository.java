package br.org.cac.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.org.cac.models.Colaborador;

/**
* Generated by Spring Data Generator on 16/03/2019
*/
@Repository
@RepositoryRestResource(path="colaboradores")
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	
//	Page<Colaborador> findByNomeIgnoreCaseContainingOrEmailIgnoreCaseContaining(String nome, String email, Pageable pageable);
//	Page<Colaborador> findByNomeContainingOrEmailContainingAllIgnoreCase(String nome, String email, Pageable pageable);
	Page<Colaborador> findByNomeContainingOrEmailContainingOrCelularContaining(String nome, String email, String celular, Pageable pageable);
	Page<Colaborador> findByNomeContainingOrEmailContainingOrCelularContaining(String parametro, Pageable pageable);
//	List<Colaborador> findByNomeContaining(String parametro);
	
	
	List<Colaborador> findByNomeContainingAllIgnoreCase(String parametro);
	

}
