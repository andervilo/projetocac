package br.ord.cac.services;

import org.springframework.stereotype.Service;

import br.ord.cac.DTO.ItemCampanhaDTO;
import br.ord.cac.arquitetura.GenericeService;
import br.ord.cac.models.ItemCampanha;
import br.ord.cac.repositories.ItemCampanhaRepository;

@Service
public class ServiceItemCampanha extends GenericeService<ItemCampanha, ItemCampanhaRepository, ItemCampanhaDTO> {

}
