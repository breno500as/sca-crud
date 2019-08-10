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

	/**
	 * Método para o agendamento de manutenção para os insumos.
	 * 
	 * @param agendaManutencaoInsumo - {@link AgendaManutencaoInsumo}.
	 * @return - {@link Veiculo }
	 */
	@PostMapping
	@ResponseBody
	public String agendaManutencao(@RequestBody AgendaManutencaoInsumo agendaManutencaoInsumo) {

		// TODO - Validações de data, campos obrigatórios, etc.
		final Optional<CodigoEspecificoInsumo> condigoEspecificoInsumo = this.codigoEspecificoInsumoRespository.findById(agendaManutencaoInsumo.getCodigoEspecificoInsumo().getId());

		if (condigoEspecificoInsumo.isPresent()) {
			throw new RuntimeException("O insumo de código " + condigoEspecificoInsumo.get().getCodigo()+ " já possui um agendamento");
		}

		this.agendaManutencaorepository.save(agendaManutencaoInsumo);

		return "ok";
	}

}
