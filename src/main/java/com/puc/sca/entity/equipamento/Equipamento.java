package com.puc.sca.entity.equipamento;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;
import com.puc.sca.tipo.Status;

/**
 * Entidade base para equipamentos utilizados na mineiração. Britadores, trituradores, etc.
 * @author breno
 */

@Entity
public class Equipamento extends BaseEntity {

	private static final long serialVersionUID = -5507305901881709760L;

	@NotNull
	private Status status;

	/**
	 * Um identificador exclusivo vindo de fábrica daquele equipamento.
	 */
	@NotNull
	private String numeroSerie;

	@NotNull
	private Date dataCadastro = new Date();

	@NotNull
	@ManyToOne
	private TipoEquipamento tipoEquipamento;

	@NotNull
	@ManyToOne
	private MarcaModeloEquipamento marcaModeloEquipamento;

	private String observacoesDeManuseio;

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public String getObservacoesDeManuseio() {
		return observacoesDeManuseio;
	}

	public void setObservacoesDeManuseio(String observacoesDeManuseio) {
		this.observacoesDeManuseio = observacoesDeManuseio;
	}

	public MarcaModeloEquipamento getMarcaModeloEquipamento() {
		return marcaModeloEquipamento;
	}

	public void setMarcaModeloEquipamento(MarcaModeloEquipamento marcaModeloEquipamento) {
		this.marcaModeloEquipamento = marcaModeloEquipamento;
	}
}
