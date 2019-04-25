package br.ord.cac.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ord.cac.DTO.ColaboradorDTO;
import br.ord.cac.arquitetura.GenericeService;
import br.ord.cac.models.Colaborador;
import br.ord.cac.repositories.ColaboradorRepository;

@Service
public class ServiceColaborador extends GenericeService<Colaborador, ColaboradorRepository, ColaboradorDTO> {
	
	public Page<Colaborador> findAll(Pageable pageable) {
		return getRepository().findAll(pageable);
	}
	
}
