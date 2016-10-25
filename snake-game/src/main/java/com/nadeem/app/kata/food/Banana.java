package com.nadeem.app.kata.food;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Banana implements Food {

	@Override
	public String getName() {
		return "Banana";
	}

	@Override
	public int getBonus() {
		return 5;
	}

	@Override
	public char getSymbol() {
		return 'B';
	}

}
