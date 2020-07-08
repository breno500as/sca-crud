package com.puc.sca.crud.entity.insumo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.puc.sca.crud.entity.BaseEntity;

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

	public static final String NAO_ENCONTRADO = "Insumo não encontrado!";

	@NotNull
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@NotNull
	@ManyToOne
	private TipoInsumo tipoInsumo;

	@NotNull
	@ManyToOne
	private SubTipoInsumo subTipoInsumo;

	@ManyToOne
	private TipoMarcaModelo tipoMarcaModelo;

	@OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CodigoEspecificoInsumo> codigosEspecificosInsumo;

	private String observacoes;

	private String linkInformacoesTecnicasFornecedor;

	private Integer quantidade;

	public List<CodigoEspecificoInsumo> getCodigosEspecificosInsumo() {
		return codigosEspecificosInsumo;
	}

	public void setCodigosEspecificosInsumo(List<CodigoEspecificoInsumo> codigosEspecificosInsumo) {
		this.codigosEspecificosInsumo = codigosEspecificosInsumo;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoInsumo getTipoInsumo() {
		return tipoInsumo;
	}

	public void setTipoInsumo(TipoInsumo tipoInsumo) {
		this.tipoInsumo = tipoInsumo;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public TipoMarcaModelo getTipoMarcaModelo() {
		return tipoMarcaModelo;
	}

	public void setTipoMarcaModelo(TipoMarcaModelo tipoMarcaModelo) {
		this.tipoMarcaModelo = tipoMarcaModelo;
	}

	public SubTipoInsumo getSubTipoInsumo() {
		return subTipoInsumo;
	}

	public void setSubTipoInsumo(SubTipoInsumo subTipoInsumo) {
		this.subTipoInsumo = subTipoInsumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((subTipoInsumo == null) ? 0 : subTipoInsumo.hashCode());
		result = prime * result + ((tipoInsumo == null) ? 0 : tipoInsumo.hashCode());
		result = prime * result + ((tipoMarcaModelo == null) ? 0 : tipoMarcaModelo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Insumo other = (Insumo) obj;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (subTipoInsumo == null) {
			if (other.subTipoInsumo != null)
				return false;
		} else if (!subTipoInsumo.equals(other.subTipoInsumo))
			return false;
		if (tipoInsumo == null) {
			if (other.tipoInsumo != null)
				return false;
		} else if (!tipoInsumo.equals(other.tipoInsumo))
			return false;
		if (tipoMarcaModelo == null) {
			if (other.tipoMarcaModelo != null)
				return false;
		} else if (!tipoMarcaModelo.equals(other.tipoMarcaModelo))
			return false;
		return true;
	}

}
