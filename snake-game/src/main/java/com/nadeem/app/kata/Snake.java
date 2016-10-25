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
		initPosition.markSnakePart();
	}

	public void grow(final Cell nextCell) { 
		this.head = nextCell;
		this.body.addLast(nextCell);
		nextCell.markSnakePart();
		nextCell.setFood(null);		
	}

	public void move(final Cell nextPosition) {
		Cell tail = this.body.removeLast();
		tail.markEmpty();
		this.head = nextPosition;
		this.body.addFirst(this.head);
		this.head.markSnakePart();		
	}

	public boolean crashWithIteself(final Cell nextPosition) {
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
