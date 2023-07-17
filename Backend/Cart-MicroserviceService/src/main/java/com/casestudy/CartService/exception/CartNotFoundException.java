package com.casestudy.CartService.exception;

public class CartNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CartNotFoundException() {
		super();

	}

	public CartNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public CartNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CartNotFoundException(String message) {
		super(message);

	}

	public CartNotFoundException(Throwable cause) {
		super(cause);

	}

}
