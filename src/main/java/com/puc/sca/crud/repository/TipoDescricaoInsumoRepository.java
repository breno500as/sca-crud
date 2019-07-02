package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.puc.sca.crud.entity.insumo.tipo.TipoDescricaoInsumo;

@Repository
@RestResource(exported = false)
public interface TipoDescricaoInsumoRepository extends CrudRepository<TipoDescricaoInsumo, Long> {

}
