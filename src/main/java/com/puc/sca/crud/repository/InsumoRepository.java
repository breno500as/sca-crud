package com.puc.sca.crud.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;

public interface InsumoRepository extends PagingAndSortingRepository<Insumo, Long> {
	
	 Page<Insumo> findAllByTipoInsumo(TipoInsumo tipoInsumo, Pageable pageable);
}
