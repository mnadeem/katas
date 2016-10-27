package com.nadeem.app.kata;

/**
 * @author Nadeem Mohammad
 *
 */
public enum Color {
	WHITE('W'), BLACK('B');

	private char code;
	private Color(char code) {
		this.code = code;
	}

	public char getCode() {
		return code;
	}
}
