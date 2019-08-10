package com.puc.sca.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;

public interface CodigoEspecificoInsumoRepository extends CrudRepository<CodigoEspecificoInsumo, Long>{
	
	List<CodigoEspecificoInsumo> findAllByInsumo(Insumo insumo);

}
