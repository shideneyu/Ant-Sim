package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelFood {

	public List<Integer> getRandomCoordonates() {
	    List<Integer> foodRandomPosition = new ArrayList<Integer>();
	    Random generator = new Random();
	    // 20 is the step
	    foodRandomPosition.add(20*(Math.round((generator.nextInt(500) + 1)/20)));
	    foodRandomPosition.add(20*(Math.round((generator.nextInt(500) + 1)/20)));
		return foodRandomPosition;
	}

}
