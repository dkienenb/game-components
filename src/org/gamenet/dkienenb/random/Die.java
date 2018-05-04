package org.gamenet.dkienenb.random;

import java.util.Random;

public class Die {

	private Random random = new Random();
	private int currentNumber = -1;
	private final int numberOfSides;

	public Die(int numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public Die(Integer numberOfSides) {
		this.numberOfSides = numberOfSides;
	}

	public Die(Random random, int numberOfSides) {
		this.random = random;
		this.numberOfSides = numberOfSides;
	}

	public int getNumber() {
		return currentNumber;
	}

	public int roll() {
		return currentNumber = 1 + random.nextInt(numberOfSides);
	}

}
