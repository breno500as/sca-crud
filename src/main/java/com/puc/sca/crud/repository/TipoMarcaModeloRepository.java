package com.puc.sca.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;

public interface TipoMarcaModeloRepository extends CrudRepository<TipoMarcaModelo, Long> {

	List<TipoMarcaModelo> findBySubTipoInsumo(SubTipoInsumo subTipoInsumo);

}
