package com.puc.sca.crud.entity.insumo;

import java.util.UUID;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Instrumentos que serão utilizados pelos topografos para estudos na
 * mineiração.
 * 
 * @author breno
 */

@Entity
@DiscriminatorValue("INSTRUMENTO_TOPOGRAFIA")
public class InstrumentoTopografia extends Insumo {

	private static final long serialVersionUID = -5922477861010679228L;

	@NotNull
	private String codigoInstrumento = UUID.randomUUID().toString();

	public String getCodigoInstrumento() {
		return codigoInstrumento;
	}

	public void setCodigoInstrumento(String codigoInstrumento) {
		this.codigoInstrumento = codigoInstrumento;
	}

}
