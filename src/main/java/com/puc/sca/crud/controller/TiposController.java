package com.puc.sca.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.sca.crud.entity.insumo.tipo.TipoDescricaoInsumo;
import com.puc.sca.crud.entity.insumo.tipo.TipoMarcaModelo;
import com.puc.sca.crud.repository.TipoDescricaoInsumoRepository;
import com.puc.sca.crud.repository.TipoMarcaModeloRepository;

/**
 * API que disponibiliza os tipos de  marcas e tipos de insumos já previamente cadastrados.
 * @author breno
 *
 */

@RestController
@RequestMapping("tipos")
public class TiposController {

	@Autowired
	private TipoMarcaModeloRepository tipoMarcaModeloRepository;

	@Autowired
	private TipoDescricaoInsumoRepository tipoDescricaoInsumoRepository;

	@GetMapping("marcas-modelo")
	public Iterable<TipoMarcaModelo> marcasModelo() {
		return tipoMarcaModeloRepository.findAll();
	}

	@GetMapping("descricoes-insumo")
	public Iterable<TipoDescricaoInsumo> descricoesInsumo() {
		return tipoDescricaoInsumoRepository.findAll();
	}

}
