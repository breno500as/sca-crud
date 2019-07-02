package com.puc.sca.crud.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.AgendaManutencaoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.Veiculo;
import com.puc.sca.crud.repository.AgendaManutencaoInsumoRepository;

@RestController
@RequestMapping("agendas-manutencao")
public class AgendaManutencaoController {

	@Autowired
	private AgendaManutencaoInsumoRepository agendaManutencaoInsumoRepository;

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
		final Insumo insumo = this.entityManager.find(Insumo.class, agendaManutencaoInsumo.getInsumo().getId());

		if (insumo.getAgendaManutencaoInsumo() != null) {
			throw new RuntimeException("Esse insumo já possui um agendamento");
		}

		this.agendaManutencaoInsumoRepository.save(agendaManutencaoInsumo);

		return "ok";
	}

}
