package com.puc.sca.crud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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

import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.repository.CodigoEspecificoInsumoRepository;
import com.puc.sca.crud.repository.InsumoRepository;

@RestController
@RequestMapping("insumos")
public class InsumoController {

	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private CodigoEspecificoInsumoRepository codigoEspecificoInsumoRespository;
	
	 

	@PostMapping
	public Insumo save(@RequestBody Insumo insumo) {
		
		if (insumo.getCodigosConcatenadosInsumo() != null && !insumo.getCodigosConcatenadosInsumo().isEmpty()) {
			 this.saveCodigoEspecificoInsumo(insumo);
		} 
		
		return this.insumoRepository.save(insumo);
	}
	

	
	@PutMapping("{id}")
	public Insumo update(@PathVariable(value = "id") Long id, @RequestBody Insumo insumo) {
		 
		Insumo insumoDB = this.insumoRepository.findById(id).get();
		
		BeanUtils.copyProperties(insumo, insumoDB);
		insumoDB.setTipoMarcaModelo(insumo.getTipoMarcaModelo().getId() == null ? null : insumo.getTipoMarcaModelo());
   	
		if (insumo.getCodigosConcatenadosInsumo() != null && !insumo.getCodigosConcatenadosInsumo().isEmpty()) {
			 
			 List<CodigoEspecificoInsumo> codigosEspecificosDelete = this.codigoEspecificoInsumoRespository.findAllByInsumo(insumoDB);
			 if (codigosEspecificosDelete != null && !codigosEspecificosDelete.isEmpty()) {
				  this.codigoEspecificoInsumoRespository.deleteAll(codigosEspecificosDelete);
			 }
			
			 this.saveCodigoEspecificoInsumo(insumoDB);
		}
		
		return this.insumoRepository.save(insumoDB);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		Insumo insumo = this.insumoRepository.findById(id).get();
		this.insumoRepository.delete(insumo);
	}
	
	@GetMapping("{id}")
	public Insumo findById(@PathVariable(value = "id") Long id) {
		
		Optional<Insumo> optional = this.insumoRepository.findById(id);

		if (optional.isPresent()) {
			Insumo insumo = optional.get();
			
			if (insumo.getCodigosEspecificosInsumo() != null && !insumo.getCodigosEspecificosInsumo().isEmpty()) {
				insumo.setCodigosConcatenadosInsumo(insumo.getCodigosEspecificosInsumo().stream().map(c -> c.getCodigo()).collect(Collectors.joining(",")));
			}
			
			return insumo;
			
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
			result = this.insumoRepository.findAllByTipoInsumo(new TipoInsumo(tipoInsumo), pageable);
		} else {
			result =  this.insumoRepository.findAll(pageable);
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
	
	private void saveCodigoEspecificoInsumo(Insumo insumo) {
		 if (insumo.getCodigosConcatenadosInsumo().contains(",")) {
			 insumo.setCodigosEspecificosInsumo((Arrays.asList(insumo.getCodigosConcatenadosInsumo().split(",")).stream().map(codigo -> new CodigoEspecificoInsumo(insumo,codigo)).collect(Collectors.toList())));
		 } else {
			 insumo.setCodigosEspecificosInsumo(new ArrayList<CodigoEspecificoInsumo>());
			 insumo.getCodigosEspecificosInsumo().add(new CodigoEspecificoInsumo(insumo,insumo.getCodigosConcatenadosInsumo()));
		 }
		
	}
	

}
