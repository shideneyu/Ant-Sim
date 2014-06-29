package controllers;

import java.util.ArrayList;
import java.util.List;

import models.ModelAnt;

public class ControllerAnt {

    private ModelAnt modelAnt;
	public ControllerAnt(int x, int y) {
		this.modelAnt = new ModelAnt(x, y);
	}
	
	public List<Integer> getNewPosition(int oldPositionX, int oldPositionY) {
		this.modelAnt.setPositionX(this.modelAnt.randomposition(oldPositionX));
		this.modelAnt.setPositionY(this.modelAnt.randomposition(oldPositionY));
	    List<Integer> antPosition = new ArrayList<Integer>();

	    antPosition.add(this.modelAnt.getPositionX());
		antPosition.add(this.modelAnt.getPositionY());
		return antPosition;
	}

}
