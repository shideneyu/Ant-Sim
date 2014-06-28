package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Ant  extends JPanel {
	private int x;
	private int y;
	public Ant(Colony colony) {
		int timerDelay = 20;
		new Timer(timerDelay, new ActionListener(){
		  public void actionPerformed(ActionEvent e) {
		    x = randomposition(x);
		    y = randomposition(y);
		    repaint();
		  }
		}).start();
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
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
		g.fillRect(this.x, this.y, 10, 10);
    }

}
