package com.puc.sca.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.entity.insumo.Maquina;

@RepositoryRestResource(collectionResourceRel = "maquinas", path = "maquinas")
public interface MaquinaRepository extends PagingAndSortingRepository<Maquina, Long> {

}
