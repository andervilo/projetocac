package br.ord.cac.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ord.cac.DTO.ColaboradorDTO;
import br.ord.cac.arquitetura.AbstractRestController;
import br.ord.cac.models.Colaborador;
import br.ord.cac.services.ServiceColaborador;

@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorRest extends AbstractRestController<Colaborador, ServiceColaborador, ColaboradorDTO> {

}
