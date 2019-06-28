package com.puc.sca.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.Maquina;

@RepositoryRestResource(collectionResourceRel = "maquinas", path = "maquinas")
public interface MaquinaRepository extends PagingAndSortingRepository<Maquina, Long> {

}
