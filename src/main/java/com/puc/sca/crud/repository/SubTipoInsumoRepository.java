package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;

@RepositoryRestResource(collectionResourceRel = "subtipos-insumo-descricao" ,path = "subtipos-insumo-descricao")
public interface SubTipoInsumoRepository extends CrudRepository<SubTipoInsumo, Long> {

}
