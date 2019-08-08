package com.puc.sca.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;
import com.puc.sca.crud.repository.TipoMarcaModeloRepository;

@RestController
@RequestMapping("tipos-marca-modelo")
public class TipoMarcaModeloController {

	@Autowired
	private TipoMarcaModeloRepository repository;

	@GetMapping
	public List<TipoMarcaModelo> findAllBySubTipoInsumo(@RequestParam("subTipoInsumo") Long subTipoInsumo) {
		return this.repository.findBySubTipoInsumo(new SubTipoInsumo(subTipoInsumo));
	}
}
