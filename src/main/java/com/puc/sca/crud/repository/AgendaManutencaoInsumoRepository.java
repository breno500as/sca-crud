package com.puc.sca.crud.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.puc.sca.crud.entity.insumo.AgendaManutencaoInsumo;
import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;

public interface AgendaManutencaoInsumoRepository extends CrudRepository<AgendaManutencaoInsumo, Long> {
	
	Optional<AgendaManutencaoInsumo> findByCodigoEspecificoInsumo(CodigoEspecificoInsumo codigoEspecificoInsumo);
}
