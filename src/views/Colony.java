package views;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controllers.ControllerColony;

public class Colony {
	private int x;
	private int y;
	public Colony() {
		// Show colony
		ControllerColony myColony = new ControllerColony();
		int[] colonyLocation = myColony.create(20,20);

		this.x = colonyLocation[0];
		this.y = colonyLocation[1];
	}
	
}
