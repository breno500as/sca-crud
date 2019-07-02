package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.puc.sca.crud.entity.insumo.tipo.TipoMarcaModelo;

@Repository
@RestResource(exported = false)
public interface TipoMarcaModeloRepository extends CrudRepository<TipoMarcaModelo, Long> {

}
