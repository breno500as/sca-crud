package com.puc.sca.crud.entity.insumo.tipo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;

@Entity
public class TipoMarcaModelo extends BaseEntity {

	private static final long serialVersionUID = 7624651984961508447L;

	@NotNull
	private String marca;

	@NotNull
	private String modelo;

	@ManyToOne
	@NotNull
	private SubTipoInsumo subTipoInsumo;

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

	public SubTipoInsumo getSubTipoInsumo() {
		return subTipoInsumo;
	}

	public void setSubTipoInsumo(SubTipoInsumo subTipoInsumo) {
		this.subTipoInsumo = subTipoInsumo;
	}

}
