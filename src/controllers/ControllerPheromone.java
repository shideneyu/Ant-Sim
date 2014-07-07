package controllers;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import models.ModelPheromone;

public class ControllerPheromone {
    
    private ArrayList<models.ModelPheromone> pheromoneList ;
    private int decrease = 100; //nb to decrease the pheromone countdown

    public ControllerPheromone() {
        this.pheromoneList = new ArrayList<>();
    }
    
    //See antData in GroundView class (list of positions and bearFood of ants)
    public void refresh( Hashtable<Integer, List<Integer>> antsData){
        
        //We decrease the Countdown for all pheromone
        for(ModelPheromone onePheromone : pheromoneList) {
            onePheromone.decreaseCountdown(decrease);
        }
        
        //We add new pheromone if needed
        for(int i = 0 ; i<antsData.size(); i++){ //For each ant
            
            if( antsData.get(i).get(2).equals(1) ){ //If ant transport Food
               ModelPheromone onePheromone = new ModelPheromone(antsData.get(i).get(0), antsData.get(i).get(1)); //We create a pheromone at current location
               
               int index = pheromoneList.indexOf(onePheromone) ; //Index of current pheromone
   
               if( index == -1 ){ //If there is no pheromone we add it
                   pheromoneList.add(onePheromone);
               } else { //if there is a pheromone, we increase his countdown.
                   ModelPheromone otherPheromone = pheromoneList.get(index) ;
                   otherPheromone.increaseCountdown(); //Increase the countdown by a default value in the model
               }
            }
        } 
        
    }

    public List<List<Integer>> getPheromoneList() {
        List<List<Integer>> pheromoneListAll = new ArrayList<>();
        for(ModelPheromone onePheromone : pheromoneList){
            List<Integer> current = new ArrayList<>();
            current.add(onePheromone.getX());
            current.add(onePheromone.getY());
            current.add(onePheromone.getCountdown());
            pheromoneListAll.add(current);
        }
        return pheromoneListAll;
    }

}
