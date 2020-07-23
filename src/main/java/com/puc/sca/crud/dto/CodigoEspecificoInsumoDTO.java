package com.puc.sca.crud.dto;

public class CodigoEspecificoInsumoDTO extends BaseDTO {

	private static final long serialVersionUID = -2738522769477382778L;

	private String codigo;

	private AgendaManutencaoInsumoDTO agendaManutencao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public AgendaManutencaoInsumoDTO getAgendaManutencao() {
		return agendaManutencao;
	}

	public void setAgendaManutencao(AgendaManutencaoInsumoDTO agendaManutencao) {
		this.agendaManutencao = agendaManutencao;
	}

}
