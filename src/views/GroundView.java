package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.text.View;

import controllers.ControllerColony;

public class GroundView extends JPanel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x=1;
    private int y=1;

    //Constructor 
    public GroundView() {
    	
    }
    

	public int randomposition(int value) {
        Random random = new Random();
		
		if (random.nextBoolean() == true) {
			if (value+1 != 500) {
				value++;
			}
		}
		else {
			if (value-1 != 0) {
				value--;	
			}
		}
		return value;
	}


    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    	     public void run() {
		        JFrame frame = new JFrame();
		        frame.setSize(500, 500);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setVisible(true);
		        Colony myColony = new Colony();
		        frame.add(myColony);
    	     }
    	});

    }

}
