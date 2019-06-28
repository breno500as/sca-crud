package com.puc.sca.entity.insumo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Entidade base para máquinas utilizadas na mineiração. Britadores,
 * trituradores, etc.
 * 
 * @author breno
 */

@Entity
@DiscriminatorValue("MAQUINA")
public class Maquina extends Insumo {

	private static final long serialVersionUID = -5507305901881709760L;

	/**
	 * Um identificador exclusivo vindo de fábrica daquela máquina.
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
