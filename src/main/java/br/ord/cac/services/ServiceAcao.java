package br.ord.cac.services;

import org.springframework.stereotype.Service;

import br.ord.cac.DTO.AcaoDTO;
import br.ord.cac.models.Acao;
import br.ord.cac.repositories.AcaoRepository;
import br.ord.cac.arquitetura.GenericeService;

@Service
public class ServiceAcao extends GenericeService<Acao, AcaoRepository, AcaoDTO> {

}
