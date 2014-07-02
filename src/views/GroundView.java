package views;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.View;

import controllers.ControllerAnt;
import controllers.ControllerColony;
import controllers.ControllerFood;
import controllers.ControllerGround;

public class GroundView extends JPanel {
	// Serialization
	private static final long serialVersionUID = 1L;
	// Initializing variables configuration
	// Hill Variables
	private int hillPositionX=1;
    private int hillPositionY=1;
    private int hillWidth = 50;
    private int hillHeight = 50;
    // Ant Variables
    private ControllerAnt ControllerAnt;
    private Hashtable<Integer, List<Integer>> antsData=new Hashtable<Integer, List<Integer>>();
	private int antInitialPositionX = 0;
	private int antInitialPositionY = 0;
	private int antNumber = 25;
	private int antId = 0;
    // Food Variables
	private ControllerFood ControllerFood;
	private Hashtable<Integer, List<Integer>> foodList=new Hashtable<Integer, List<Integer>>();
	private int foodQuantity = 50;
	private int foodId = 0;
	// Others
	private int timerPause = 200;
	private int foodHarvested = 0;


    //Constructor 
    public GroundView() {
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    	     public void run() {		        
		        JFrame frame = new JFrame();
		        frame.setSize(500, 500);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);
		        frame.add(new GroundView());
    	     }
    	});
    }


	private void drawFood(Graphics g, int foodId) {
		g.setColor(Color.green);
		g.fillRect(this.foodList.get(foodId).get(0), this.foodList.get(foodId).get(1), 10, 10);
	}

	private void drawAnts(Graphics g, int antId) {
		// If the ant doesn't have any food
		if (this.antsData.get(antId).get(2).equals(0)) {
			// Update the new position of the current ant
			this.antsData.put(antId, this.ControllerAnt.getNewData(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1), this.antsData.get(antId).get(2)));
			// If the new antPosition contains a food
			ControllerGround groundController = new ControllerGround(this.antsData, this.foodList, antId);
			this.antsData = (Hashtable<Integer, List<Integer>>) groundController.getProcessedPosition().get(0);
			this.foodList = (Hashtable<Integer, List<Integer>>) groundController.getProcessedPosition().get(1);
		}
		// If the ant has food
		else {
			// Return to base
			this.antsData.get(antId).set(0, this.ControllerAnt.returnToBase(this.antsData.get(antId)).get(0));
			this.antsData.get(antId).set(1, this.ControllerAnt.returnToBase(this.antsData.get(antId)).get(1));
			// If the ant has returned to the mine
			if(this.antsData.get(antId).get(0).equals(0) && this.antsData.get(antId).get(1).equals(0)) {
			  // Remove its food
			  this.antsData.get(antId).set(2, 0);
			  this.foodHarvested++;
			  System.out.print("Food harvested: " + this.foodHarvested + "\n");
			}
			
		}
		if (this.antsData.get(antId).get(2) == 0) {
			g.setColor(Color.black);
		}
		else {
			g.setColor(Color.blue);
		}
		g.fillArc(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1), 20, 20, 25, 40);
	}

	private void drawAntHill(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.hillPositionX, this.hillPositionY, this.hillWidth, this.hillHeight);
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw ant hill
        drawAntHill(g);

        // Draw food
        if (this.foodList.size() < this.foodQuantity) {
            // Add a new food
            this.ControllerFood = new ControllerFood();
            List<Integer> foodPosition = this.ControllerFood.getFoodCoordonates();
            // Append a new food on the food list
            this.foodList.put(this.foodId++, foodPosition);
        }

        // Draw ants
        if (this.antsData.size() < this.antNumber) {
            // Add a new ant
            this.ControllerAnt = new ControllerAnt(this.antInitialPositionX,this.antInitialPositionY);
            List<Integer> antPosition = this.ControllerAnt.getNewData(this.antInitialPositionX,this.antInitialPositionY, 0);
            // Append a new ant to the ants List
        	this.antsData.put(this.antId++, antPosition);
        }

        // Draw every ants
        int antId = 0;
		do {
			drawAnts(g, antId);
			antId++;
        } while (antId < this.antsData.size());
		
        // Draw every food
		for(Integer foodId : this.foodList.keySet()) {
			drawFood(g, foodId);
			foodId++;
        }
		//System.out.print( "\nFirst food, position x:" +this.foodList.get(0).get(0)  + "\n");
		//System.out.print( "\nFirst food, position y:" +this.foodList.get(0).get(1)  + "\n");

		//System.out.print( "First ant, position x:" +this.antsData.get(0).get(0));
		//System.out.print( "\n\nFirst ant, position y:" +this.antsData.get(0).get(1)  + "\n");
		

		// 1 second of pause between each action
		Timer resetTimer = new Timer(this.timerPause, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		resetTimer.setRepeats(false);
        //resetTimer.setCoalesce(false);
        resetTimer.start();
        
    }

}
