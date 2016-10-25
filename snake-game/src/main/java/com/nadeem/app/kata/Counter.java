package com.nadeem.app.kata;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Counter {

	private int score = 0;

	private static final Counter INSTANCE = new Counter();

	private Counter() {

	}

	public static Counter getInstance() {
		return INSTANCE;
	}
	
	public void incrementScoreBy(int score) {
		this.score = this.score + score;
	}
	
	public int getScore() {
		return this.score;
	}
}
