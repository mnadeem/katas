package com.nadeem.app.kata;

public class NoQuarterState implements State {

	private final VendingMachine vendingMachine;

	public NoQuarterState(final VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void insertQuarter() {
		System.out.println("A quarter has been inserted");
		this.vendingMachine.setState(this.vendingMachine.getHaQuarterState());		
	}

	public void ejectQuarter() {
		System.out.println("A quarter has not been inserted");		
	}

	public void turnCrank() {
		System.out.println("A quarter should be inserted before turing crank");
	}

	public void dispense() {
		System.out.println("Payement has not been made yet");		
	}

}
