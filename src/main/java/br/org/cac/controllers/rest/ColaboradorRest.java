package br.org.cac.controllers.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.cac.DTO.ColaboradorDTO;
import br.org.cac.arquitetura.AbstractRestController;
import br.org.cac.models.Colaborador;
import br.org.cac.services.ServiceColaborador;

@RestController
@RequestMapping("/api/v1/colaboradores")
public class ColaboradorRest extends AbstractRestController<Colaborador, ServiceColaborador, ColaboradorDTO> {

}
