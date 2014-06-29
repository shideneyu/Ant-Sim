package controllers;

public class ControllerColony {

	private int x = 20;
	private int y = 20;
	// Constructor
	public ControllerColony() {
	}

	public int[] create(int x, int y) {
		this.x = 20;
		this.y = 20;
		int[] colonyLocation = {this.x, this.y};
		return colonyLocation;
	}

	public boolean generateAnts() {
		return false;
		//ControllerAnt myAnt = new ControllerAnt();
		//return myAnt.create();
	}

}
