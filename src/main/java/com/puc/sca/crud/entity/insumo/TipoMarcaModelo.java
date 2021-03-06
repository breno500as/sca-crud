package com.puc.sca.crud.entity.insumo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;

@Entity
public class TipoMarcaModelo extends BaseEntity {

	private static final long serialVersionUID = 7624651984961508447L;
	
	public static final String NAO_ENCONTRADO = "Tipo marca modelo não encontrada!";

	@NotNull
	private String marca;

	@NotNull
	private String modelo;

	@ManyToOne
	@NotNull
	private SubTipoInsumo subTipoInsumo;

	public TipoMarcaModelo() {
	}

	public TipoMarcaModelo(Long id) {
		setId(id);
	}

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
