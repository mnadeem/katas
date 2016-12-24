package com.nadeem.app.kata;

public class HasQuarterState implements State {
	
	private final VendingMachine vendingMachine;
	
	public HasQuarterState(final VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void insertQuarter() {
		System.out.println("You cant insert another quarter");
	}

	public void ejectQuarter() {
		System.out.println("Quarter has been returned");
		this.vendingMachine.setState(this.vendingMachine.getNoQuarterState());
	}

	public void turnCrank() {
		System.out.println("You turned crank");
		this.vendingMachine.setState(this.vendingMachine.getSoldState());
	}

	public void dispense() {
		System.out.println("Nothing to dispense");
	}

}
