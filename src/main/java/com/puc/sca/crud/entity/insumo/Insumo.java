package com.puc.sca.crud.entity.insumo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.puc.sca.crud.entity.BaseEntity;

/**
 * Classe base para entidades de insumo principais da mineiradora: máquinas,
 * instrumentos de topografia, veículos, etc.
 * 
 * @author breno
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Insumo extends BaseEntity {

	private static final long serialVersionUID = 7977428935549712028L;

	@NotNull
	private Date dataCadastro = new Date();

	/**
	 * {@link TipoInsumo}.
	 */

	@NotNull
	@ManyToOne
	private TipoInsumo tipoInsumo;

	/**
	 * {@link SubTipoInsumo}.
	 */

	@NotNull
	@ManyToOne
	private SubTipoInsumo subTipoInsumo;

	public SubTipoInsumo getSubTipoInsumo() {
		return subTipoInsumo;
	}

	public void setSubTipoInsumo(SubTipoInsumo subTipoInsumo) {
		this.subTipoInsumo = subTipoInsumo;
	}

	/**
	 * {@link TipoMarcaModelo}.
	 */

	@ManyToOne
	private TipoMarcaModelo tipoMarcaModelo;

	@JsonIgnore
	@OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CodigoEspecificoInsumo> codigosEspecificosInsumo;

	private String observacoes;

	private String linkInformacoesTecnicasFornecedor;

	private Integer quantidade;

	@Transient
	private Long totalElementos;
	
	@Transient
	private String codigosConcatenadosInsumo;

	/**
	 * Construtor para instanciar os relacionamentos no momento da deserialização.
	 * 
	 * @param tipoInsumo      - {@link TipoInsumo}
	 * @param subTipoInsumo   - {@link SubTipoInsumo}
	 * @param tipoMarcaModelo - {@link TipoMarcaModelo}
	 */

	@JsonCreator
	public Insumo(@JsonProperty("tipoInsumo") TipoInsumo tipoInsumo,
			@JsonProperty("subTipoInsumo") SubTipoInsumo subTipoInsumo,
			@JsonProperty("tipoMarcaModelo") TipoMarcaModelo tipoMarcaModelo) {
		this.tipoInsumo = tipoInsumo;
		this.subTipoInsumo = subTipoInsumo;
		this.tipoMarcaModelo = tipoMarcaModelo;
	}

	public Insumo() {

	}

	public List<CodigoEspecificoInsumo> getCodigosEspecificosInsumo() {
		return codigosEspecificosInsumo;
	}

	public void setCodigosEspecificosInsumo(List<CodigoEspecificoInsumo> codigosEspecificosInsumo) {
		this.codigosEspecificosInsumo = codigosEspecificosInsumo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoInsumo getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumo tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
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

	public TipoMarcaModelo getTipoMarcaModelo() {
		return tipoMarcaModelo;
	}

	public void setTipoMarcaModelo(TipoMarcaModelo tipoMarcaModelo) {
		this.tipoMarcaModelo = tipoMarcaModelo;
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
