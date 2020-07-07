package com.puc.sca.crud.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2803648218037386565L;
	
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
