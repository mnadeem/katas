package com.nadeem.app.kata.food;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Apple implements Food {

	public String getName() {
		return "Apple";
	}

	public int getBonus() {
		return 10;
	}

	public char getSymbol() {
		return 'A';
	}

	@Override
	public String toString() {
		return String.valueOf(getSymbol());
	}
	
}
