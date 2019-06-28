package com.puc.sca.crud.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.puc.sca.crud.entity.insumo.Veiculo;

@RepositoryRestResource(collectionResourceRel = "veiculos", path = "veiculos")
public interface VeiculoRepository extends PagingAndSortingRepository<Veiculo, Long> {

}
