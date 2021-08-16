package com.gomesmatheus.dscatalog.services.exceptions;

public class ResourcecNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourcecNotFoundException(String msg) {
		super(msg);
	}
}
