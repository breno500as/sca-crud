package com.puc.sca.crud.dto;

import java.io.Serializable;

import com.puc.sca.crud.enums.Fornecedor;

public class InsumoFornecedorDTO implements Serializable {

	private static final long serialVersionUID = -1542001479832969401L;

	private InsumoDTO insumo;

	private Fornecedor fornecedor;

	public InsumoDTO getInsumo() {
		return insumo;
	}

	public void setInsumo(InsumoDTO insumo) {
		this.insumo = insumo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
