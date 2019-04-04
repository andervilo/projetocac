package br.ord.cac.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ord.cac.DTO.DoacaoDTO;
import br.ord.cac.arquitetura.AbstractRestController;
import br.ord.cac.models.Doacao;
import br.ord.cac.services.ServiceDoacao;

@RestController
@RequestMapping("/api/v1/doacoes")
public class DoacaoRest extends AbstractRestController<Doacao, ServiceDoacao, DoacaoDTO> {

	
}
