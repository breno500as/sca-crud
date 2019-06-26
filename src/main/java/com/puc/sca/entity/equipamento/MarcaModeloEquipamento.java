package com.puc.sca.entity.equipamento;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

@Entity
public class MarcaModeloEquipamento extends BaseEntity {

	private static final long serialVersionUID = -1950457570555795233L;

	@NotNull
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
