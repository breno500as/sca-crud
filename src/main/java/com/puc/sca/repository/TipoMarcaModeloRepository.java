package com.puc.sca.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.puc.sca.entity.insumo.tipo.TipoMarcaModelo;

@RepositoryRestResource(collectionResourceRel = "tipos-marca-modelo", path = "tipos-marca-modelo")
public interface TipoMarcaModeloRepository extends CrudRepository<TipoMarcaModelo, Long> {

	@Override
	@RestResource(exported = false)
	default <S extends TipoMarcaModelo> S save(S entity) {
		return null;
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(Long id) {
	}
}
