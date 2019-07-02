package com.puc.sca.crud.dto;

import com.puc.sca.crud.entity.insumo.Insumo;
import com.puc.sca.crud.enums.Fornecedor;

public class InsumoFornecedorDTO {

	private Insumo insumo;

	private Fornecedor fornecedor;

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

}
