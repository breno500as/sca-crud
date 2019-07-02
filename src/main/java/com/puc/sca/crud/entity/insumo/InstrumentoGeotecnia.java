package com.puc.sca.crud.entity.insumo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("INSTRUMENTO_GEOTECNIA")
public class InstrumentoGeotecnia extends Insumo {

	private static final long serialVersionUID = 8140654586429034329L;

}
