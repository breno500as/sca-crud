package com.puc.sca.entity.insumo;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Entidade base para veículos automotores para deslocamento na mineiradora ou
 * para deslocamento em vias públicas.
 * 
 * @author breno
 */

@Entity
@DiscriminatorValue("VEICULO")
public class Veiculo extends Insumo {

	private static final long serialVersionUID = -3626537777631555558L;

	@NotNull
	private Date dataFabricacao;

	/**
	 * Alguns veículos não vão possuir placa mas sim um PIN code acoplado ao chassi
	 * ou na estrutura que o compõe.
	 * 
	 * @link https://www.legisweb.com.br/legislacao/?id=317949
	 */
	private String numeroIdentificacaoVeiculo;

	private String placa;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public String getNumeroIdentificacaoVeiculo() {
		return numeroIdentificacaoVeiculo;
	}

	public void setNumeroIdentificacaoVeiculo(String numeroIdentificacaoVeiculo) {
		this.numeroIdentificacaoVeiculo = numeroIdentificacaoVeiculo;
	}

}
