package com.puc.sca.crud.entity.insumo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;

@Entity
public class SubTipoInsumo extends BaseEntity {

	private static final long serialVersionUID = 7368127298635893508L;

	@NotNull
	private String descricao;

	@ManyToOne
	@NotNull
	private TipoInsumo tipoInsumo;

	public SubTipoInsumo() {
	}

	public SubTipoInsumo(Long id) {
		setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoInsumo getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumo tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
	}

}
