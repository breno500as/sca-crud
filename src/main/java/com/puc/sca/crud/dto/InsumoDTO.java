package com.puc.sca.crud.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.puc.sca.crud.entity.insumo.SubTipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoInsumo;
import com.puc.sca.crud.entity.insumo.TipoMarcaModelo;

public class InsumoDTO extends BaseDTO {

	private static final long serialVersionUID = -3375989611473738207L;

	private LocalDateTime dataCadastro = LocalDateTime.now();

	@NotNull(message = "Tipo insumo é obrigatório")
	private TipoInsumoDTO tipoInsumo;

	@NotNull(message = "Sub tipo é obrigatório")
	private SubTipoInsumoDTO subTipoInsumo;

	@NotNull(message = "Tipo marca modelo é obrigatório")
	private TipoMarcaModeloDTO tipoMarcaModelo;

	private String observacoes;

	private String linkInformacoesTecnicasFornecedor;

	private Integer quantidade;

	private Long totalElementos;

	private String codigosConcatenadosInsumo;
	
	/**
	 * Construtor para instanciar os relacionamentos no momento da deserialização.
	 * 
	 * @param tipoInsumo      - {@link TipoInsumo}
	 * @param subTipoInsumo   - {@link SubTipoInsumo}
	 * @param tipoMarcaModelo - {@link TipoMarcaModelo}
	 */

	@JsonCreator
	public InsumoDTO(@JsonProperty("tipoInsumo") TipoInsumoDTO tipoInsumo,
			@JsonProperty("subTipoInsumo") SubTipoInsumoDTO subTipoInsumo,
			@JsonProperty("tipoMarcaModelo") TipoMarcaModeloDTO tipoMarcaModelo) {
		this.tipoInsumo = tipoInsumo;
		this.subTipoInsumo = subTipoInsumo;
		this.tipoMarcaModelo = tipoMarcaModelo;
	}
	
	public InsumoDTO() {
		
	}

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
