package com.puc.sca.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.TipoInsumoRepository;

@RestController
@RequestMapping("tipos-insumo")
public class TipoInsumoController {

	private static final Logger LOG = LoggerFactory.getLogger(TipoInsumoController.class);

	@Autowired
	private TipoInsumoRepository repository;

	@GetMapping
	@Cacheable("tipos-insumo")
	public Iterable<TipoInsumo> findAll() {
		TipoInsumoController.LOG.info("tipos insumo controller: {}", this.repository);
		return this.repository.findAll();
	}

}
