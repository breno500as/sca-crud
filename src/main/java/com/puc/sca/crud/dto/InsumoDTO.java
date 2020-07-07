package com.puc.sca.crud.dto;

import java.time.LocalDateTime;

public class InsumoDTO extends BaseDTO {

	private static final long serialVersionUID = -3375989611473738207L;

	private LocalDateTime dataCadastro = LocalDateTime.now();

	private TipoInsumoDTO tipoInsumo;

	private SubTipoInsumoDTO subTipoInsumo;

	private TipoMarcaModeloDTO tipoMarcaModelo;

	private String observacoes;

	private String linkInformacoesTecnicasFornecedor;

	private Integer quantidade;

	private Long totalElementos;

	private String codigosConcatenadosInsumo;

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoInsumoDTO getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumoDTO tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

	public SubTipoInsumoDTO getSubTipoInsumo() {
		return subTipoInsumo;
	}

	public void setSubTipoInsumo(SubTipoInsumoDTO subTipoInsumo) {
		this.subTipoInsumo = subTipoInsumo;
	}

	public TipoMarcaModeloDTO getTipoMarcaModelo() {
		return tipoMarcaModelo;
	}

	public void setTipoMarcaModelo(TipoMarcaModeloDTO tipoMarcaModelo) {
		this.tipoMarcaModelo = tipoMarcaModelo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getLinkInformacoesTecnicasFornecedor() {
		return linkInformacoesTecnicasFornecedor;
	}

	public void setLinkInformacoesTecnicasFornecedor(String linkInformacoesTecnicasFornecedor) {
		this.linkInformacoesTecnicasFornecedor = linkInformacoesTecnicasFornecedor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Long getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(Long totalElementos) {
		this.totalElementos = totalElementos;
	}

	public String getCodigosConcatenadosInsumo() {
		return codigosConcatenadosInsumo;
	}

	public void setCodigosConcatenadosInsumo(String codigosConcatenadosInsumo) {
		this.codigosConcatenadosInsumo = codigosConcatenadosInsumo;
	}

}
