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
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.View;

import controllers.ControllerAnt;
import controllers.ControllerColony;
import controllers.ControllerFood;

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
	private int antNumber = 5;
	private int antId = 0;
    // Food Variables
	private ControllerFood ControllerFood;
	private Hashtable<Integer, List<Integer>> foodList=new Hashtable<Integer, List<Integer>>();
	private int foodQuantity = 5;
	private int foodId = 0;
	// Others
	private int timerPause = 1000;


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
		g.fillRect(this.foodList.get(foodId).get(0), this.foodList.get(foodId).get(1), 5, 10);
	}

	private void drawAntHill(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.hillPositionX, this.hillPositionY, this.hillWidth, this.hillHeight);
	}

	private void drawAnts(Graphics g, int antId) {
		// Update the new position of the current ant
		this.antsData.put(antId, this.ControllerAnt.getNewPosition(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1)));

		g.setColor(Color.black);
		g.fillArc(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1), 15, 30, 25, 40);
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
            List<Integer> antPosition = this.ControllerAnt.getNewPosition(this.antInitialPositionX,this.antInitialPositionY);
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
        int foodId = 0;
		do {
			drawFood(g, foodId);
			foodId++;
        } while (foodId < this.foodList.size());
		System.out.print( "\nFirst food, position x:" +this.foodList.get(0).get(0)  + "\n");
		System.out.print( "\nFirst food, position y:" +this.foodList.get(0).get(1)  + "\n");

		
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
