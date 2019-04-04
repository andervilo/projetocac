package br.ord.cac.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.ord.cac.models.Doacao;

/**
* Generated by Spring Data Generator on 16/03/2019
*/
@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer>, JpaSpecificationExecutor<Doacao> {

}
