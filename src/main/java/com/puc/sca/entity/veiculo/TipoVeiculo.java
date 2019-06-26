package com.puc.sca.entity.veiculo;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

// escavadeira
// retroescavadeira
// caminhão
// trator

@Entity
public class TipoVeiculo extends BaseEntity {

	private static final long serialVersionUID = 5768324680208789428L;

	@NotNull
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}
