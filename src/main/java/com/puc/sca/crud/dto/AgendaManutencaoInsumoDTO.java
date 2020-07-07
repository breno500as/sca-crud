package com.puc.sca.crud.dto;

import java.time.LocalDateTime;

import com.puc.sca.crud.enums.TipoManutencaoInsumo;

public class AgendaManutencaoInsumoDTO extends BaseDTO {

	private static final long serialVersionUID = 4502978882713109042L;

	private CodigoEspecificoInsumoDTO codigoEspecificoInsumo;

	private LocalDateTime dataInicio;

	private LocalDateTime dataTermino;

	private TipoManutencaoInsumo tipoManutencaoInsumo;

	private Boolean manutencaoConcluida;

	public CodigoEspecificoInsumoDTO getCodigoEspecificoInsumo() {
		return codigoEspecificoInsumo;
	}

	public void setCodigoEspecificoInsumo(CodigoEspecificoInsumoDTO codigoEspecificoInsumo) {
		this.codigoEspecificoInsumo = codigoEspecificoInsumo;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}

	public TipoManutencaoInsumo getTipoManutencaoInsumo() {
		return tipoManutencaoInsumo;
	}

	public void setTipoManutencaoInsumo(TipoManutencaoInsumo tipoManutencaoInsumo) {
		this.tipoManutencaoInsumo = tipoManutencaoInsumo;
	}

	public Boolean getManutencaoConcluida() {
		return manutencaoConcluida;
	}

	public void setManutencaoConcluida(Boolean manutencaoConcluida) {
		this.manutencaoConcluida = manutencaoConcluida;
	}

}
