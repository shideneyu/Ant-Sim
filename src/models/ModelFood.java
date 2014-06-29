package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelFood {

	public List<Integer> getRandomCoordonates() {
	    List<Integer> foodRandomPosition = new ArrayList<Integer>();
	    Random generator = new Random();

	    foodRandomPosition.add(generator.nextInt(500) + 1);
	    foodRandomPosition.add(generator.nextInt(500) + 1);

		return foodRandomPosition;
	}

}
