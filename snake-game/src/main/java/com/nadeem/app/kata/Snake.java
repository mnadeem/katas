package com.nadeem.app.kata;

import java.util.LinkedList;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class Snake {

	private Cell head;
	private LinkedList<Cell> body;

	public Snake(final Cell initPosition) {
		this.head = initPosition;
		this.body = new LinkedList<Cell>();
		this.body.add(initPosition);
		initPosition.markSnakeHead();
	}

	public void grow(final Cell nextCell) { 
		this.head = nextCell;
		this.body.addLast(nextCell);
		nextCell.markSnakeHead();
		nextCell.setFood(null);		
	}

	public void move(final Cell nextPosition) {
		Cell tail = this.body.removeLast();
		tail.markEmpty();
		this.head = nextPosition;
		markBodyAsPart();
		this.body.addFirst(this.head);
		this.head.markSnakeHead();	
	}

	private void markBodyAsPart() {
		for (Cell cell : this.body) {
			cell.markSnakePart();
		}
	}

	public boolean crashesWithItself(final Cell nextPosition) {
		for (Cell position : this.body) {
			if (position.equals(nextPosition)) {
				return true;
			}
		}
		return false;
	}

	public Cell getHead() {
		return this.head;
	}
}
