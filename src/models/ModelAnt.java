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
			if (value+10 < 500) {
				value = value + 10;
			}
		}
		else {
			if (value-10 > 0) {
				value = value - 10;	
			}
		}
		return value;
	}
}
