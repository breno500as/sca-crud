package com.puc.sca.crud.dto;

import com.puc.sca.crud.entity.BaseEntity;

public class SubTipoInsumoDTO extends BaseEntity {

	private static final long serialVersionUID = 1782474594890983956L;

	private TipoInsumoDTO tipoInsumo;

	private String descricao;

	public TipoInsumoDTO getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumoDTO tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
