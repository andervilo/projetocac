package br.ord.cac.services;

import org.springframework.stereotype.Service;

import br.ord.cac.DTO.DoacaoDTO;
import br.ord.cac.arquitetura.GenericeService;
import br.ord.cac.models.Doacao;
import br.ord.cac.repositories.DoacaoRepository;

@Service
public class ServiceDoacao extends GenericeService<Doacao, DoacaoRepository, DoacaoDTO> {
}
