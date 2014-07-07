package controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class ControllerGround {

    private Hashtable<Integer, List<Integer>> antsData=new Hashtable<Integer, List<Integer>>();
	private Hashtable<Integer, List<Integer>> foodList=new Hashtable<Integer, List<Integer>>();
	private int antId;
	List<Object> ProcessedData = new ArrayList<Object>();

	public ControllerGround(Hashtable<Integer, List<Integer>> antsData,
			Hashtable<Integer, List<Integer>> foodList, int antId) {
		this.antsData = antsData;
		this.foodList = foodList;
		this.antId = antId;
	}

	public List<Object> getProcessedPosition() {
		outerloop:
		for (Entry<Integer, List<Integer>> foodPosition : this.foodList.entrySet()) {
			// If food position == ant position
			if ((foodPosition.getValue().get(0).equals(this.antsData.get(this.antId).get(0))) && (foodPosition.getValue().get(1).equals(this.antsData.get(this.antId).get(1)))) {
				// Make the ant bear the food
                                this.antsData.get(this.antId).set(2, 1);
				// Remove the food
				this.foodList.remove(foodPosition.getKey());
				break outerloop;
			}
		}
	    this.ProcessedData.add(this.antsData);
	    this.ProcessedData.add(this.foodList);
		return this.ProcessedData;
	}

}
