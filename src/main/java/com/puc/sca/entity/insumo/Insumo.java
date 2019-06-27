package com.puc.sca.entity.insumo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.base.BaseEntity;
import com.puc.sca.entity.insumo.periodo.PeriodoManutencao;
import com.puc.sca.entity.insumo.tipo.TipoMarcaModelo;
import com.puc.sca.entity.insumo.tipo.TipoDescricaoInsumo;
import com.puc.sca.enuns.Status;

/**
 * Classe base para entidades de insumo, máquinas da mineiradora, instrumentos,
 * veículos, etc.
 * 
 * @author breno
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Insumo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Status status;

	@NotNull
	private Date dataCadastro = new Date();

	@NotNull
	@ManyToOne
	private TipoDescricaoInsumo tipoDescricaoInsumo;

	@NotNull
	@ManyToOne
	private TipoMarcaModelo tipoMarcaModelo;

	@OneToOne
	private PeriodoManutencao periodoManutencao;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoDescricaoInsumo getTipoDescricaoInsumo() {
		return tipoDescricaoInsumo;
	}

	public void setTipoDescricaoInsumo(TipoDescricaoInsumo tipoDescricaoInsumo) {
		this.tipoDescricaoInsumo = tipoDescricaoInsumo;
	}

	public TipoMarcaModelo getTipoMarcaModelo() {
		return tipoMarcaModelo;
	}

	public void setTipoMarcaModelo(TipoMarcaModelo tipoMarcaModelo) {
		this.tipoMarcaModelo = tipoMarcaModelo;
	}

	public PeriodoManutencao getPeriodoManutencao() {
		return periodoManutencao;
	}

	public void setPeriodoManutencao(PeriodoManutencao periodoManutencao) {
		this.periodoManutencao = periodoManutencao;
	}

}
