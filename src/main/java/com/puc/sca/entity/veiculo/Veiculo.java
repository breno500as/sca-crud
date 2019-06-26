package com.puc.sca.entity.veiculo;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

/**
 * Entidade base para veículos automotores para deslocamento na mineiradora ou
 * para deslocamento em vias públicas.
 * 
 * @author breno
 */

@Entity
public class Veiculo extends BaseEntity {

	private static final long serialVersionUID = -3626537777631555558L;

	@NotNull
	private Date dataFabricacao;

	@NotNull
	private MarcaModeloVeiculo modeloVeiculo;

	@NotNull
	private TipoVeiculo tipoVeiculo;

	/**
	 * Alguns veículos não vão possuir placa mas sim um PIN code acoplado ao chassi
	 * ou na estrutura que o compõe.
	 * 
	 * @link https://www.legisweb.com.br/legislacao/?id=317949
	 */
	private String numeroIdentificacaoProduto;

	private String placa;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(final String placa) {
		this.placa = placa;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(final Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(final TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public MarcaModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(final MarcaModeloVeiculo modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public String getNumeroIdentificacaoProduto() {
		return numeroIdentificacaoProduto;
	}

	public void setNumeroIdentificacaoProduto(final String numeroIdentificacaoProduto) {
		this.numeroIdentificacaoProduto = numeroIdentificacaoProduto;
	}

}
