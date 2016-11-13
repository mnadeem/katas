package com.nadeem.app.kata;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public abstract class Game {

	private final Board board;
	private final CellRenderer cellRenderer;
	private final Snake snake;

	public Game(final Board board, final CellRenderer cellRenderer) {
		this.board = board;
		this.cellRenderer = cellRenderer;
		this.snake = new Snake(board.getSnakeInitialPosition());
	}

	public void move(final Direction direction) {
		Cell currentPosition = this.snake.getHead();
		Cell nextCell = this.board.getNextPosition(currentPosition, direction);
		if (snake.crashesWithItself(nextCell)) {
			throw new GameOverException();
		} else {	
			if (nextCell.getFood() != null) {
				Counter.getInstance().incrementScoreBy(nextCell.getFood().getBonus());
				this.snake.grow(nextCell);
				this.board.generateFood();
			}
			this.snake.move(nextCell);
		}
	}

	public void display() {
		this.board.display(cellRenderer);
	}
}
