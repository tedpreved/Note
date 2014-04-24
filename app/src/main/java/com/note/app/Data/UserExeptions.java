package com.note.app.Data;

public class UserExeptions extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Error error;

	public UserExeptions(Error error) {
		this.error = error;
	}

	public enum Error {
		USER_NOT_FOUND, WRONG_PASSWORD, NEW_PASS_SAME_AS_PREVIOUS, WRONG_OLD_PASSWORD
	}

	public Error getError() {
		return error;
	}

}
