package com.puc.sca.crud.dto;

import com.puc.sca.crud.enums.Fornecedor;

public class InsumoFornecedorDTO {

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
