package com.puc.sca.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.repository.InsumoRepository;

@RestController
@RequestMapping("insumos")
public class InsumoController {

	@Autowired
	private InsumoRepository insumoRepository;

	@PostMapping
	public Insumo save(@RequestBody Insumo insumo) {
		return this.insumoRepository.save(insumo);
	}
	

	@GetMapping
	public Iterable<Insumo> get(@RequestParam("page") Integer page, 
			                           @RequestParam("size") Integer size,
			                           @RequestParam(name = "sort", defaultValue = "id") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		return this.insumoRepository.findAll(paging).getContent();
	}

}
