package com.puc.sca.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.puc.sca.crud.entity.insumo.tipo.TipoDescricaoInsumo;

@RepositoryRestResource(collectionResourceRel = "tipos-descricao-insumo", path = "tipos-descricao-insumo")
public interface TipoDescricaoInsumoRepository extends CrudRepository<TipoDescricaoInsumo, Long> {

	@Override
	@RestResource(exported = false)
	default <S extends TipoDescricaoInsumo> S save(S entity) {
		return null;
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(Long id) {
	}
}
