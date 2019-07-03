package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;

@RepositoryRestResource(collectionResourceRel = "tipos-marca-modelo" ,path = "tipos-marca-modelo")
public interface TipoMarcaModeloRepository extends CrudRepository<TipoMarcaModelo, Long> {

}
