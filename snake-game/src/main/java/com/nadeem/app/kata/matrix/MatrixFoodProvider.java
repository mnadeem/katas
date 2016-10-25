package com.nadeem.app.kata.matrix;

import java.util.concurrent.ThreadLocalRandom;

import com.nadeem.app.kata.food.Apple;
import com.nadeem.app.kata.food.Banana;
import com.nadeem.app.kata.food.Cherry;
import com.nadeem.app.kata.food.Food;
import com.nadeem.app.kata.food.FoodProvider;

public class MatrixFoodProvider implements FoodProvider {

	public Food provideFood() {
		int rn = generateRandomNumber();
		if (rn == 1) {
			return new Banana();
		} else if (rn == 2) {
			return new Apple();
		} else {
			return new Cherry();
		}			
	}

	private int generateRandomNumber() {
		int min = 1;
		int max = 3;
		int rn = ThreadLocalRandom.current().nextInt(min, max + 1);
		return rn;
	}		
}
