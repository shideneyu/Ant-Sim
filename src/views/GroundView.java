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
	private int antPositionY = 0;
	private int antPositionX = 0;
	private int antNumber = 5;
	private int antId = 0;
	// Others
	private int timerPause = 1000;

	private Hashtable<Integer, List<Integer>> antsData=new Hashtable<Integer, List<Integer>>();
	private ControllerAnt ControllerAnt;

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

	private void drawAntHill(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.hillPositionX, this.hillPositionY, this.hillWidth, this.hillHeight);
	}

	private void drawAnts(Graphics g, int antId) {
		// Update the new position of the current ant
		this.antsData.put(antId, this.ControllerAnt.getNewPosition(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1)));

		g.setColor(Color.black);
		g.fillRect(this.antsData.get(antId).get(0), this.antsData.get(antId).get(1), 10, 10);
	}

	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw ant hill
        drawAntHill(g);

        if (this.antsData.size() < this.antNumber) {
            // Add a new ant
            this.ControllerAnt = new ControllerAnt(this.antPositionX,this.antPositionY);
            List<Integer> antPosition = this.ControllerAnt.getNewPosition(this.antPositionX,this.antPositionY);
            // Append a new ant to the ants List
        	this.antsData.put(this.antId++, antPosition);
        }
        // Draw every ants
        int count = 0;
		do {
			drawAnts(g, count);
			count++;
        } while (count < this.antsData.size());
		
		System.out.print( "\n\nFirst ant, position y:" +this.antsData.get(0).get(1)  + "\n");
		
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
