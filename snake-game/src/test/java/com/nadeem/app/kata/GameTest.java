package com.nadeem.app.kata;

import java.util.Scanner;

import com.nadeem.app.kata.matrix.Matrix2DGame;

/**
 * 
 * @author Nadeem Mohammad
 *
 */
public class GameTest {

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in);) {
			Game game = new Matrix2DGame();
			System.out.println("Welcome to Snake game");
			System.out.println("1.UP , 2.DOWN, 3.LEFT, 4.RIGHT");
			game.display();
			try {
				while(true) {
					int input = scanner.nextInt();
					Direction direction = getDirection(input);
					game.move(direction);
					game.display();
				}
			} catch(GameOverException e) {
				System.out.println("Game Over!, your score is : "+ Counter.getInstance().getScore());
			}			
		}				
	}

	private static Direction getDirection(int input) {
		if (input == 1) {
			return Direction.UP;
		}else if (input == 2) {
			return Direction.DOWN;
		}else if (input == 3) {
			return Direction.LEFT;
		} else {
			return Direction.RIGHT;
		}
	}
}
