package com.puc.sca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.entity.insumo.tipo.TipoDescricaoInsumo;

@RepositoryRestResource(collectionResourceRel = "tipos-descricao-insumo", path = "tipos-descricao-insumo")
public interface TipoDescricaoInsumoRepository extends CrudRepository<TipoDescricaoInsumo, Long> {

}
