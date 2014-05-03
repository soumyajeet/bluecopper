package com.bluecoppertech.dao;

@SuppressWarnings("serial")

public class DataAccessException extends Exception {
	public DataAccessException() {
		super();
	}

	public DataAccessException(String s) {
		super(s);
	}

	public DataAccessException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public DataAccessException(Throwable throwable) {
		super(throwable);
	}
}
