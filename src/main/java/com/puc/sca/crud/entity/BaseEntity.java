package com.puc.sca.crud.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * Classe base para todas as entidades, sobrescrevendo equals e hashcode.
 * 
 * @author breno
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	 

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		final BaseEntity baseEntity = (BaseEntity) obj;

		if (this.getId() != baseEntity.getId() && (this.getId() == null || !this.id.equals(baseEntity.id))) {
			return false;
		}
		return true;

	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "BaseEntity[ID=" + id + ']';
	}

}
