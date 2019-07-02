package com.puc.sca.crud.entity.insumo;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.AgendaManutencaoInsumo;
import com.puc.sca.crud.entity.BaseEntity;
import com.puc.sca.crud.entity.insumo.tipo.TipoDescricaoInsumo;
import com.puc.sca.crud.entity.insumo.tipo.TipoMarcaModelo;

/**
 * Classe base para entidades de insumo principais da mineiradora: máquinas,
 * instrumentos de topografia, veículos, etc.
 * 
 * @author breno
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Insumo extends BaseEntity {

	private static final long serialVersionUID = 7977428935549712028L;

	@NotNull
	private Date dataCadastro = new Date();

	@NotNull
	@ManyToOne
	private TipoDescricaoInsumo tipoDescricaoInsumo;

	@ManyToOne
	private TipoMarcaModelo tipoMarcaModelo;

	@OneToOne(mappedBy = "insumo")
	private AgendaManutencaoInsumo agendaManutencaoInsumo;

	private String observacoes;

	private String linkInformacoesTecnicasFornecedor;

	private String codigoInsumo = UUID.randomUUID().toString();

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoDescricaoInsumo getTipoDescricaoInsumo() {
		return tipoDescricaoInsumo;
	}

	public void setTipoDescricaoInsumo(TipoDescricaoInsumo tipoDescricaoInsumo) {
		this.tipoDescricaoInsumo = tipoDescricaoInsumo;
	}

	public TipoMarcaModelo getTipoMarcaModelo() {
		return tipoMarcaModelo;
	}

	public void setTipoMarcaModelo(TipoMarcaModelo tipoMarcaModelo) {
		this.tipoMarcaModelo = tipoMarcaModelo;
	}

	public AgendaManutencaoInsumo getAgendaManutencaoInsumo() {
		return agendaManutencaoInsumo;
	}

	public void setAgendaManutencaoInsumo(AgendaManutencaoInsumo agendaManutencaoInsumo) {
		this.agendaManutencaoInsumo = agendaManutencaoInsumo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getLinkInformacoesTecnicasFornecedor() {
		return linkInformacoesTecnicasFornecedor;
	}

	public void setLinkInformacoesTecnicasFornecedor(String linkInformacoesTecnicasFornecedor) {
		this.linkInformacoesTecnicasFornecedor = linkInformacoesTecnicasFornecedor;
	}

	public String getCodigoInsumo() {
		return codigoInsumo;
	}

	public void setCodigoInsumo(String codigoInsumo) {
		this.codigoInsumo = codigoInsumo;
	}

}
