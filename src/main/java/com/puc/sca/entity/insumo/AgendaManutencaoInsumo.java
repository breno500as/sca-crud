package com.puc.sca.entity.insumo;

import java.util.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

/**
 * Entidade para agendamento de manutenção do insumo.
 * @author Breno
 *
 */

@Entity
public class AgendaManutencaoInsumo extends BaseEntity {

	private static final long serialVersionUID = 6638011007908343013L;

	@NotNull
	private Date dataInicio;

	@NotNull
	private Date dataTermino;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

}
