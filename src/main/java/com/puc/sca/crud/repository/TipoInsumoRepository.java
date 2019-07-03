package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.TipoInsumo;


@RepositoryRestResource(collectionResourceRel = "tipos-insumo" ,path = "tipos-insumo")
public interface TipoInsumoRepository extends CrudRepository<TipoInsumo, Long> {

}
