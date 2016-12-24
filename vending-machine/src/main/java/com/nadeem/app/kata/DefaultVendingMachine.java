package com.nadeem.app.kata;

public class DefaultVendingMachine implements VendingMachine {
	
	private int count = 0;
	
	private State noQuarterState = new NoQuarterState(this);
	private State haQuarterState = new HasQuarterState(this);
	private State soldState = new SoldState(this);
	private State soldOutState = new SoldOutState(this);
	
	private State state = soldOutState;

	public DefaultVendingMachine(int count) {
		this.count = count;
		if (count > 0) {
			this.state = noQuarterState;
		}
	}

	public void insertQuarter() {
		this.state.insertQuarter();
	}

	public void ejectQuarter() {
		this.state.ejectQuarter();
	}

	public void turnCrank() {
		this.state.turnCrank();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void releaseBall() {
		System.out.println("A gumcall comes rolling out");
		if (count != 0) {
			count = count -1;
		}

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(State noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public State getHaQuarterState() {
		return haQuarterState;
	}

	public void setHaQuarterState(State haQuarterState) {
		this.haQuarterState = haQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public State getState() {
		return state;
	}
	
	

}
