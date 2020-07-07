package com.puc.sca.crud.dto;

public class TipoMarcaModeloDTO extends BaseDTO {

	private static final long serialVersionUID = 4781941397217188577L;

	private String marca;

	private String modelo;

	private SubTipoInsumoDTO subTipoInsumo;

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

	public SubTipoInsumoDTO getSubTipoInsumo() {
		return subTipoInsumo;
	}

	public void setSubTipoInsumo(SubTipoInsumoDTO subTipoInsumo) {
		this.subTipoInsumo = subTipoInsumo;
	}

}
