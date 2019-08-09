package com.puc.sca.crud.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.InsumoRepository;

@RestController
@RequestMapping("insumos")
public class InsumoController {

	@Autowired
	private InsumoRepository repository;

	@PostMapping
	public Insumo save(@RequestBody Insumo insumo) {
		return this.repository.save(insumo);
	}
	
	@PutMapping("{id}")
	public Insumo update(@PathVariable(value = "id") Long id, @RequestBody Insumo insumo) {
		 
		Insumo insumoDB = this.repository.findById(id).get();
		insumoDB.setTipoInsumo(insumo.getTipoInsumo());
		insumoDB.setSubTipoInsumo(insumo.getSubTipoInsumo());
		insumoDB.setTipoMarcaModelo(insumo.getTipoMarcaModelo().getId() == null ? null : insumo.getTipoMarcaModelo());
		insumoDB.setQuantidade(insumo.getQuantidade());
		insumoDB.setLinkInformacoesTecnicasFornecedor(insumo.getLinkInformacoesTecnicasFornecedor());
		insumoDB.setObservacoes(insumo.getObservacoes());
   	
		return this.repository.save(insumoDB);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		Insumo insumo = this.repository.findById(id).get();
		this.repository.delete(insumo);
	}
	
	@GetMapping("{id}")
	public Insumo findById(@PathVariable(value = "id") Long id) {
		
		Optional<Insumo> optional = this.repository.findById(id);

		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	

	@GetMapping
	public Iterable<Insumo> findAll(@RequestParam("page") Integer page, 
			                        @RequestParam("size") Integer size,
			                        @RequestParam(value = "tipoInsumo", required = false) Long tipoInsumo,
			                        @RequestParam(name = "sort", defaultValue = "id") String sort) {
		Pageable pageable = PageRequest.of(page -1, size, Sort.by(sort));
		
		Page<Insumo> result =  null;
		
		if (tipoInsumo != null) {
			result = this.repository.findAllByTipoInsumo(new TipoInsumo(tipoInsumo), pageable);
		} else {
			result =  this.repository.findAll(pageable);
		}
		
		if (result.get() != null) {
			List<Insumo> insumos = result.get().collect(Collectors.toList());
			if (insumos.size() > 0) {
				insumos.get(0).setTotalElementos(result.getTotalElements());
			}
			
			return insumos;
		}
		
		return Collections.emptyList();
		
	}

}
