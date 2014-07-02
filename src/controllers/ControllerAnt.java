package controllers;

import java.util.ArrayList;
import java.util.List;

import models.ModelAnt;

public class ControllerAnt {

    private ModelAnt modelAnt;
    private int newPositionX;
    private int newPositionY;
	public ControllerAnt(int x, int y) {
		this.modelAnt = new ModelAnt(x, y);
	}
	
	public List<Integer> getNewData(int oldPositionX, int oldPositionY, int hasFood) {
		// In order for the ant to move anywhere but the current position
		do {
			this.newPositionX = this.modelAnt.randomposition(oldPositionX);
			this.newPositionY = this.modelAnt.randomposition(oldPositionY);
		} while((Integer.valueOf(this.newPositionX).equals(Integer.valueOf(oldPositionX))) && (Integer.valueOf(this.newPositionY).equals(Integer.valueOf(oldPositionY))));

		this.modelAnt.setPositionX(this.newPositionX);
		this.modelAnt.setPositionY(this.newPositionY);
	    List<Integer> antData = new ArrayList<Integer>();

	    antData.add(this.modelAnt.getPositionX());
	    antData.add(this.modelAnt.getPositionY());
	    antData.add(hasFood);
		return antData;
	}

	public List<Integer> returnToBase(List<Integer> ant) {
		if(ant.get(0) > 0) {
			ant.set(0, (ant.get(0) - 10));
		}
		if (ant.get(1) > 0 ) {
			ant.set(1, (ant.get(1) - 10));
		}
		return ant;
	}

}
