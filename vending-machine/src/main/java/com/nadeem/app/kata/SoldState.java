package com.nadeem.app.kata;

public class SoldState implements State {
	private final VendingMachine vendingMachine;
	
	public SoldState(final VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void insertQuarter() {
		System.out.println("Please wait, we are already giving you a gum ball");
	}

	public void ejectQuarter() {
		System.out.println("Sorry you have already turned the crank");		
	}

	public void turnCrank() {
		System.out.println("Turning twice does not get you another gum ball");
		
	}

	public void dispense() {
		this.vendingMachine.releaseBall();
		
		if (this.vendingMachine.getCount() > 0) {
			this.vendingMachine.setState(this.vendingMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumb ball");
			this.vendingMachine.setState(this.vendingMachine.getSoldOutState());
		}
	}
}
