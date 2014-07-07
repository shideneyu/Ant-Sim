package controllers;

import java.util.List;

import models.ModelFood;

public class ControllerFood {

	private ModelFood modelFood;
	
	// Constructor
	public ControllerFood() {
		this.modelFood = new ModelFood();
	}
	public List<Integer> getFoodCoordonates() {
		return this.modelFood.getRandomCoordonates();
	}

}
