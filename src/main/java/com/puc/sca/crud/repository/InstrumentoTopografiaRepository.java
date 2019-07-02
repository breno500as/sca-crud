package com.puc.sca.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.InstrumentoTopografia;

@RepositoryRestResource(collectionResourceRel = "instrumentos-topografia", path = "instrumentos-topografia")
public interface InstrumentoTopografiaRepository extends PagingAndSortingRepository<InstrumentoTopografia, Long> {

}
