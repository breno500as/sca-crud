package com.puc.sca.crud.entity.insumo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;

/**
 * Tabela que possui uma série de identificadores e códigos para um único
 * insumo.
 * 
 * @author Breno
 *
 */

@Entity
public class CodigoEspecificoInsumo extends BaseEntity {

	private static final long serialVersionUID = -5425802637883335902L;

	/**
	 * {@link Insumo}.
	 */

	@ManyToOne
	private Insumo insumo;

	@NotNull
	private String codigo;
	
	/**
	 * {@link AgendaManutencaoInsumo}.
	 */

	@OneToOne(mappedBy = "codigoEspecificoInsumo")
	private AgendaManutencaoInsumo agendaManutencao;

	public CodigoEspecificoInsumo() {
	}
	
	public CodigoEspecificoInsumo(Long id) {
	  this.id = id;
	}
	

	public CodigoEspecificoInsumo(Insumo insumo, String codigo) {
		this.codigo = codigo;
		this.insumo = insumo;
	}

	public CodigoEspecificoInsumo(String codigo) {
		this.codigo = codigo;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public AgendaManutencaoInsumo getAgendaManutencao() {
		return agendaManutencao;
	}

	public void setAgendaManutencao(AgendaManutencaoInsumo agendaManutencao) {
		this.agendaManutencao = agendaManutencao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
