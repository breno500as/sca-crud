package com.puc.sca.crud.entity.insumo.tipo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.puc.sca.crud.entity.BaseEntity;
import com.puc.sca.crud.enums.TipoInsumo;

/**
 * Tipos específicos pré determinados de máquinas, veículos e instrumentos
 * topográficos.
 * 
 * @author Breno
 *
 */

@Entity
public class TipoDescricaoInsumo extends BaseEntity {

	private static final long serialVersionUID = 7368127298635893508L;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private TipoInsumo tipoInsumo;

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
