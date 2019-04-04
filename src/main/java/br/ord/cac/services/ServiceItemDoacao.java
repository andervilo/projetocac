package br.ord.cac.services;

import org.springframework.stereotype.Service;

import br.ord.cac.DTO.ItemDoacaoDTO;
import br.ord.cac.arquitetura.GenericeService;
import br.ord.cac.models.ItemDoacao;
import br.ord.cac.repositories.ItemDoacaoRepository;

@Service
public class ServiceItemDoacao extends GenericeService<ItemDoacao, ItemDoacaoRepository, ItemDoacaoDTO> {

}
