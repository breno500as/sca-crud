package com.puc.sca.crud.entity.insumo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;
import com.puc.sca.crud.enums.TipoManutencaoInsumo;

/**
 * Entidade para agendamento de manutenção do insumo.
 * 
 * @author Breno
 *
 */

@Entity
public class AgendaManutencaoInsumo extends BaseEntity {

	private static final long serialVersionUID = 6638011007908343013L;

	@NotNull
	@OneToOne
	private CodigoEspecificoInsumo codigoEspecificoInsumo;

	@NotNull
	private Date dataInicio;

	@NotNull
	private Date dataTermino;

	@Enumerated(EnumType.STRING)
	private TipoManutencaoInsumo tipoManutencaoInsumo;

	private Boolean manutencaoConcluida;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public TipoManutencaoInsumo getTipoManutencaoInsumo() {
		return tipoManutencaoInsumo;
	}

	public void setTipoManutencaoInsumo(TipoManutencaoInsumo tipoManutencaoInsumo) {
		this.tipoManutencaoInsumo = tipoManutencaoInsumo;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Boolean getManutencaoConcluida() {
		return manutencaoConcluida;
	}

	public void setManutencaoConcluida(Boolean manutencaoConcluida) {
		this.manutencaoConcluida = manutencaoConcluida;
	}

	public CodigoEspecificoInsumo getCodigoEspecificoInsumo() {
		return codigoEspecificoInsumo;
	}

	public void setCodigoEspecificoInsumo(CodigoEspecificoInsumo codigoEspecificoInsumo) {
		this.codigoEspecificoInsumo = codigoEspecificoInsumo;
	}

}
