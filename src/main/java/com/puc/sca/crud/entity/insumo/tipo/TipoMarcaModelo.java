package com.puc.sca.crud.entity.insumo.tipo;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.puc.sca.crud.entity.BaseEntity;

@Entity
public class TipoMarcaModelo extends BaseEntity {

	private static final long serialVersionUID = 7624651984961508447L;

	private String marca;

	private String modelo;

	@OneToOne
	private TipoDescricaoInsumo tipoDescricaoInsumo;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public TipoDescricaoInsumo getTipoDescricaoInsumo() {
		return tipoDescricaoInsumo;
	}

	public void setTipoDescricaoInsumo(TipoDescricaoInsumo tipoDescricaoInsumo) {
		this.tipoDescricaoInsumo = tipoDescricaoInsumo;
	}

}
