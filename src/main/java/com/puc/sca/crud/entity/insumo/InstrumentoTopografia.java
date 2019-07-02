package com.puc.sca.crud.entity.insumo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Instrumentos que serão utilizados pelos topografos para estudos na
 * mineiração.
 * 
 * @author breno
 */

@Entity
@DiscriminatorValue("INSTRUMENTO_TOPOGRAFIA")
public class InstrumentoTopografia extends Insumo {

	private static final long serialVersionUID = 4452819486289041400L;

}
