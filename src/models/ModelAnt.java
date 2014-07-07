package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelAnt {

	private int positionX;
	private int positionY;
	private boolean bearFood;
	private List<Integer> antPosition = new ArrayList<Integer>();

	public ModelAnt(int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public boolean isBearFood() {
		return bearFood;
	}
	public void setBearFood(boolean bearFood) {
		this.bearFood = bearFood;
	}
	public int randomposition(int value) {
        Random random = new Random();
		if (random.nextBoolean() == true) {
			if (value+1 <= 500) {
				if (random.nextBoolean() == true) {
					value = value + 1;
				}
			}
		}
		else {
			if (value-1 >= 0) {
				if (random.nextBoolean() == true) {
					value = value - 1;
				}
			}
		}
		return value;
	}
}
