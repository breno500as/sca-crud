package com.puc.sca.crud.entity.insumo;

import java.util.UUID;

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

	@ManyToOne
	private Insumo insumo;

	@NotNull
	private String uuid;

	private String placa;

	private String numeroDeSerie;

	@OneToOne(mappedBy = "codigoEspecificoInsumo")
	private AgendaManutencaoInsumo agendaManutencao;

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}

	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}

	public AgendaManutencaoInsumo getAgendaManutencao() {
		return agendaManutencao;
	}

	public void setAgendaManutencao(AgendaManutencaoInsumo agendaManutencao) {
		this.agendaManutencao = agendaManutencao;
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
