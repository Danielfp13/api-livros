package com.api.livros.model.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DataIntegrityException(String message) {
		super(message);
	}
}
