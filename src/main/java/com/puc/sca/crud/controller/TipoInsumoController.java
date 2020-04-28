package com.puc.sca.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.TipoInsumoRepository;

@RestController
@RequestMapping("tipos-insumo")
public class TipoInsumoController {

	@Autowired
	private TipoInsumoRepository repository;

	@GetMapping
	@Cacheable("tipos-insumo")
	public Iterable<TipoInsumo> findAll() {
		return this.repository.findAll();
	}

}
