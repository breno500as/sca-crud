package com.puc.sca.crud.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.AgendaManutencaoInsumo;
import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.repository.AgendaManutencaoInsumoRepository;
import com.puc.sca.crud.repository.CodigoEspecificoInsumoRepository;

@RestController
@RequestMapping("agendas-manutencao")
public class AgendaManutencaoController {

	@Autowired
	private AgendaManutencaoInsumoRepository agendaManutencaorepository;

	@Autowired
	private CodigoEspecificoInsumoRepository codigoEspecificoInsumoRespository;

	@PostMapping
	@ResponseBody
	public void agendaManutencao(@RequestBody AgendaManutencaoInsumo agendaManutencaoInsumo) {
		
		final Optional<CodigoEspecificoInsumo> codigoEspecificoInsumo = this.codigoEspecificoInsumoRespository.findByCodigo(agendaManutencaoInsumo.getCodigoEspecificoInsumo().getCodigo());
		
		if (!codigoEspecificoInsumo.isPresent()) {
			throw new RuntimeException("Não foi encontrado um código de insumo com o valor: " + agendaManutencaoInsumo.getCodigoEspecificoInsumo().getCodigo());
		}
		
		CodigoEspecificoInsumo c = codigoEspecificoInsumo.get();

		// TODO - Validações de data, campos obrigatórios, filtrar pelo período informado etc.
		final Optional<AgendaManutencaoInsumo> insumoJaAgendado = this.agendaManutencaorepository.findByCodigoEspecificoInsumo(new CodigoEspecificoInsumo(c.getId()));

		if (insumoJaAgendado.isPresent()) {
			throw new RuntimeException("O insumo de código " + codigoEspecificoInsumo.get().getCodigo()+ " já possui um agendamento para o período informado");
		}

		agendaManutencaoInsumo.setCodigoEspecificoInsumo(c);
		this.agendaManutencaorepository.save(agendaManutencaoInsumo);

	}

}
