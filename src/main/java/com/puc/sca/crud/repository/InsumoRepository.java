package com.puc.sca.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.Insumo;

@RepositoryRestResource(collectionResourceRel = "insumos" ,path = "insumos")
public interface InsumoRepository extends PagingAndSortingRepository<Insumo, Long> {

}
