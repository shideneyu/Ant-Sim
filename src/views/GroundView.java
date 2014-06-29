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
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.View;

import controllers.ControllerColony;

public class GroundView extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x=1;
    private int y=1;
	private int antPositionX = 0;
	private int antPositionY = 0;

	private Hashtable<Integer, int[]> antsData=new Hashtable<Integer, int[]>();
	private int antNumber = 0;

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
		g.fillRect(this.x, this.y, 50, 50);		
	}

	private void drawAnts(Graphics g, int antNumber) {

		this.antsData.get(antNumber)[0] = randomposition(this.antsData.get(antNumber)[0]);
		this.antsData.get(antNumber)[1] = randomposition(this.antsData.get(antNumber)[1]);

		g.setColor(Color.black);
		g.fillRect(this.antsData.get(antNumber)[0], this.antsData.get(antNumber)[1], 10, 10);
		defineAntPosition();
		

        

	}

	public int getAntPositionX() {
		return antPositionX;
	}


	public int getAntPositionY() {
		return antPositionY;
	}


	public int setAntPositionX(int antPositionX) {
		this.antPositionX = antPositionX;
		return antPositionX;
	}



	public int setAntPositionY(int antPositionY) {
		this.antPositionY = antPositionY;
		return antPositionY;
	}


	public void defineAntPosition() {


	}
	public int randomposition(int value) {
        Random random = new Random();
		
		if (random.nextBoolean() == true) {
			if (value+10 < 500) {
				value = value + 10;
			}
		}
		else {
			if (value-10 > 0) {
				value = value - 10;	
			}
		}
		return value;
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawAntHill(g);
        // Add a new ant
        int[] myIntArray = {3,1};
        if (this.antsData.size() < 10) {
        	this.antsData.put(this.antNumber++, myIntArray);
        }
        // Draw every ants
        int count = 0;
		do {
			drawAnts(g, count);
			count++;
        } while (count < this.antsData.size());
		System.out.print( "\n\nshid" + this.antsData.get(0)[0] + "\n");
		Timer resetTimer = new Timer(1000, new ActionListener() {

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
