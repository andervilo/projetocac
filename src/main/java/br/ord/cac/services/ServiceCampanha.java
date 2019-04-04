package br.ord.cac.services;

import org.springframework.stereotype.Service;

import br.ord.cac.DTO.CampanhaDTO;
import br.ord.cac.arquitetura.GenericeService;
import br.ord.cac.models.Campanha;
import br.ord.cac.repositories.CampanhaRepository;

@Service
public class ServiceCampanha extends GenericeService<Campanha, CampanhaRepository, CampanhaDTO> {


}
