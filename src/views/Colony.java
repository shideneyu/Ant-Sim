package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controllers.ControllerColony;

public class Colony extends JPanel {
	private int x;
	private int y;
	public Colony() {
		// Show colony
		ControllerColony myColony = new ControllerColony();
		int[] colonyLocation = myColony.create(20,20);

		this.x = colonyLocation[0];
		this.y = colonyLocation[1];
	}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
		g.fillRect(this.x, this.y, 50, 50);
    }

}
