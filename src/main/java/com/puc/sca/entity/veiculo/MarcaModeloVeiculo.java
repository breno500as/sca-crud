package com.puc.sca.entity.veiculo;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

@Entity
public class MarcaModeloVeiculo extends BaseEntity {

	private static final long serialVersionUID = 6991524664741811556L;

	@NotNull
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}
