package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.TipoInsumo;

@RestController
@RequestMapping("tipos-insumo")
public class TipoInsumoController {
	/*
	 * @Autowired private TipoInsumoRepository repository;
	 */

	@GetMapping
	@Cacheable("tipos-insumo")
	public Iterable<TipoInsumo> findAll() {
	   List<TipoInsumo> tiposInsumos = new ArrayList<>();
	   tiposInsumos.add(new TipoInsumo(1L,"braminha"));
		return tiposInsumos;
	}

}
