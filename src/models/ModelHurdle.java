package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelHurdle {

	private List<List<Integer>> CoordinatesList = new ArrayList<List<Integer>>();
	private List<List<Integer>> fullCoordinates = new ArrayList<List<Integer>>();

	private int currentX;
	private int currentY;
	
	public List<List<Integer>> getEveryCoordinates(List<Integer> randomCoordinates) {
		this.CoordinatesList.add(randomCoordinates);
		return CoordinatesList;
	}

	public List<List<Integer>> generateFullCoordinates() {
		// Retrieving every random coordinates
		for ( List<Integer>  coordinate : this.CoordinatesList) {

			this.currentX = coordinate.get(0);			
			this.currentY = coordinate.get(1);

			// Inject a new +1 on x and y (20 times) to every position
			for (int i = 0; i < 50; i++) {
				List<Integer> currentCoordinate = new ArrayList<Integer>();
				currentCoordinate.add(this.currentX++);
				currentCoordinate.add(this.currentY++);
				this.fullCoordinates.add(currentCoordinate);
			}
		}
		return this.fullCoordinates;
	}

	public List<Integer> getRandomCoordinates() {
		List<Integer> hurdleRandomPosition = new ArrayList<Integer>();
		Random generator = new Random();
		// 20 is the step
		hurdleRandomPosition.add(20*(Math.round((generator.nextInt(500) + 1)/20)));
		hurdleRandomPosition.add(20*(Math.round((generator.nextInt(500) + 1)/20)));
		return hurdleRandomPosition;
	}
	
	public List<List<Integer>> getFullCoordinates() {
		return fullCoordinates;
	}

}
