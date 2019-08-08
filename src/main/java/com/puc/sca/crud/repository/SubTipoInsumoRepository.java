package com.puc.sca.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;


public interface SubTipoInsumoRepository extends CrudRepository<SubTipoInsumo, Long> {

	List<SubTipoInsumo> findByTipoInsumo(TipoInsumo tipoInsumo);

}
