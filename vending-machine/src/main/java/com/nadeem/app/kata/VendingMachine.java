package com.nadeem.app.kata;

public interface VendingMachine {

	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	void setState(State state);
	void releaseBall();
	
	public State getNoQuarterState();

	public State getHaQuarterState();

	public State getSoldState();

	public State getSoldOutState();
	
	int getCount();
}
