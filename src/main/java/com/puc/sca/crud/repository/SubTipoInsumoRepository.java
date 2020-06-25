package com.puc.sca.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;


// Por default @RepositoryRestResource - gera uma API REST com o nível de maturidade 3 - HATEOAS
//@RepositoryRestResource(collectionResourceRel = "subtipos-insumo", path = "subtipos-insumo")
public interface SubTipoInsumoRepository extends CrudRepository<SubTipoInsumo, Long> {

	List<SubTipoInsumo> findByTipoInsumo(TipoInsumo tipoInsumo);

}
