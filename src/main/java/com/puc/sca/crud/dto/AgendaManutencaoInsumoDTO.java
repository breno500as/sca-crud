package com.puc.sca.crud.dto;

import java.time.LocalDateTime;

import com.puc.sca.crud.entity.insumo.CodigoEspecificoInsumo;
import com.puc.sca.crud.enums.TipoManutencaoInsumo;

public class AgendaManutencaoInsumoDTO extends BaseDTO {

	private static final long serialVersionUID = 4502978882713109042L;

	private CodigoEspecificoInsumo codigoEspecificoInsumo;

	private LocalDateTime dataInicio;

	private LocalDateTime dataTermino;

	private TipoManutencaoInsumo tipoManutencaoInsumo;

	private Boolean manutencaoConcluida;

}
