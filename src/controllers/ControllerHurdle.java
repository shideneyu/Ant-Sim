package controllers;

import java.util.List;

import models.ModelHurdle;

public class ControllerHurdle {

	private ModelHurdle modelHurdle;
	private List<List<Integer>> everyCoordinates;
	
	// Constructor
	public ControllerHurdle() {
	  this.modelHurdle = new ModelHurdle();
	}

	// Has to be called first as it will get the good hurdles
	public void setHurdleCoordinates() {
		List<Integer> randomCoordinates = this.modelHurdle.getRandomCoordinates();
		this.everyCoordinates= this.modelHurdle.getEveryCoordinates(randomCoordinates);
	}

	public List<List<Integer>> getHurdleFullCoordinates() {
		return this.modelHurdle.generateFullCoordinates();
	}
}

