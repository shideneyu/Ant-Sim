package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import models.ModelAnt;
import views.StatisticsView;

public class ControllerAnt {

	private StatisticsView statisticsPanel;
    private ModelAnt modelAnt;
    private int hurdleAvoided;
    private int newPositionX;
    private int newPositionY;
	List<Integer> currentCoordinate = new ArrayList<Integer>();
	// In order to set currentCoordinate into a list, to compare it int the second do while
    List<List<Integer>> processedCurrentCoordinate = new ArrayList<List<Integer>>();
	public ControllerAnt(int x, int y) {
		this.modelAnt = new ModelAnt(x, y);
	}
	
	public List<Integer> getNewData(int oldPositionX, int oldPositionY, int hasFood, List<List<Integer>> HurdlefullCoordinatesList) {

		// In order for the ant not to move to a hurdle
		do {
			// In order for the ant to move anywhere but the current position
			do {
				this.currentCoordinate.clear();
				this.processedCurrentCoordinate.clear();
				this.newPositionX = this.modelAnt.randomposition(oldPositionX);
				this.newPositionY = this.modelAnt.randomposition(oldPositionY);
				this.currentCoordinate.add(newPositionX);
				this.currentCoordinate.add(newPositionY);
				this.processedCurrentCoordinate.add(currentCoordinate);
			} while((Integer.valueOf(this.newPositionX).equals(Integer.valueOf(oldPositionX))) && (Integer.valueOf(this.newPositionY).equals(Integer.valueOf(oldPositionY))));

		} while(isIncluded(HurdlefullCoordinatesList, this.processedCurrentCoordinate));

		this.modelAnt.setPositionX(this.newPositionX);
		this.modelAnt.setPositionY(this.newPositionY);
	    List<Integer> antData = new ArrayList<Integer>();

	    antData.add(this.modelAnt.getPositionX());
	    antData.add(this.modelAnt.getPositionY());
	    antData.add(hasFood);
		return antData;
	}

	// If the hurdlelist contains a ant position.
	private boolean isIncluded(List<List<Integer>> hurdlefullCoordinatesList, List<List<Integer>> processedCurrentCoordinate2) {
		for(int counter = 0; counter < hurdlefullCoordinatesList.size(); counter++) {
			if(processedCurrentCoordinate2.get(0).equals(hurdlefullCoordinatesList.get(counter))) {  
				// The wall does work... it's just not obvious, uncomment next line
				//System.out.print("Ant blocked by a wall!\n");
				this.statisticsPanel.setDataValues(5, this.hurdleAvoided++);
				return true;
		      }
		  }
		return false;
	}

	public List<Integer> returnToBase(List<Integer> ant, List<List<Integer>> HurdlefullCoordinatesList) {
		// While the new position has no hurdle
		do {
			if(ant.get(0) > 0) {
				ant.set(0, (ant.get(0) - 1));
			}
			if (ant.get(1) > 0 ) {
				ant.set(1, (ant.get(1) - 1));
			}
		} while(isIncluded(HurdlefullCoordinatesList, this.processedCurrentCoordinate));
		return ant;
	}

	public void setStatisticsView(StatisticsView frame) {
		this.statisticsPanel = frame;
	}
}
