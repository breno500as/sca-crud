package com.puc.sca.entity.insumo;

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

	/**
	 * Um identificador exclusivo vindo de fábrica daquele instrumento.
	 */
	@NotNull
	private String numeroSerie;

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

}
