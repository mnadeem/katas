package com.nadeem.app.kata.food;

public class Cherry implements Food {

	@Override
	public String getName() {
		return "Cherry";
	}

	@Override
	public int getBonus() {
		return 15;
	}

	@Override
	public char getSymbol() {
		return 'C';
	}
}
