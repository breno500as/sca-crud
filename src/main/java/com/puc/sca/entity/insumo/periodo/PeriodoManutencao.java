package com.puc.sca.entity.insumo.periodo;

import java.util.Date;

import javax.persistence.Entity;

import com.puc.sca.entity.base.BaseEntity;

@Entity
public class PeriodoManutencao extends BaseEntity {

	private Date dataInicio;

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
