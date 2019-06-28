package com.puc.sca.entity.insumo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.puc.sca.entity.BaseEntity;

@Entity
public class Dimensao extends BaseEntity {

	private static final long serialVersionUID = -2520867685352249459L;

	@NotNull
	private BigDecimal altura;

	@NotNull
	private BigDecimal largura;

	public BigDecimal getAltura() {
		return altura;
	}

	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}

	public BigDecimal getLargura() {
		return largura;
	}

	public void setLargura(BigDecimal largura) {
		this.largura = largura;
	}

}
