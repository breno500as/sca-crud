package com.puc.sca.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.InstrumentoGeotecnia;

@RepositoryRestResource(collectionResourceRel = "instrumentos-geotecnia", path = "instrumentos-geotecnia")
public interface InstrumentoGeotecniaRepository extends PagingAndSortingRepository<InstrumentoGeotecnia, Long> {

}
