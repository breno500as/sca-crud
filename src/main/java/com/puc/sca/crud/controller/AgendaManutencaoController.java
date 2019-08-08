package com.puc.sca.crud.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.AgendaManutencaoInsumo;
import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.repository.AgendaManutencaoInsumoRepository;

@RestController
@RequestMapping("agendas-manutencao")
public class AgendaManutencaoController {

	@Autowired
	private AgendaManutencaoInsumoRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

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
		final CodigoEspecificoInsumo condigoEspecificoInsumo = this.entityManager.find(CodigoEspecificoInsumo.class, agendaManutencaoInsumo.getCodigoEspecificoInsumo().getId());

		if (condigoEspecificoInsumo.getAgendaManutencao() != null) {
			throw new RuntimeException("O insumo de código " + condigoEspecificoInsumo.getUuid() + " já possui um agendamento");
		}

		this.repository.save(agendaManutencaoInsumo);

		return "ok";
	}

}
