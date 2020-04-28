package com.puc.sca.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.SubTipoInsumoRepository;

@RestController
@RequestMapping("subtipos-insumo")
public class SubTipoInsumoController {
	
	@Autowired
	private SubTipoInsumoRepository repository;
	
	@GetMapping
	@Cacheable("subtipos-insumo")
	public List<SubTipoInsumo> findAllBySubTipoInsumo(@RequestParam("tipoInsumo") Long tipoInsumo) {
		return this.repository.findByTipoInsumo(new TipoInsumo(tipoInsumo));
	}

}
