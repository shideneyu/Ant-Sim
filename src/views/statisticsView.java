package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class statisticsView extends JFrame
 {
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	private String hurdle_quantity    = "20";
	private String ant_current_number = "20";
	private String hurdles_avoided    = "20";
	private String food_harvested     = "20";
	private String food_quantity_left = "20";

	// Constructor of main frame
	public statisticsView()
	{
		// Set the frame characteristics
		setTitle( "Ants simulator Statistics" );
		setSize( 1000, 70 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		String columnNames[] = { "Ant Current Number", "Hurdle Quantity", "Food Quantity left", "Food harvested", "Hurdles avoided" };

		this.table = new JTable( getDataValues(), columnNames );

		scrollPane = new JScrollPane( this.table );
		topPanel.add( scrollPane, BorderLayout.CENTER );
	}

	private Object[][] getDataValues() {
		String dataValues[][] =
		{
			{ this.ant_current_number, this.hurdle_quantity, this.food_quantity_left, this.food_harvested, this.food_harvested, this.hurdles_avoided }
		};
		return dataValues;
	}

	public void setDataValues(int position, int value) {
		switch (position) 
		{ 
			case 1: this.ant_current_number = String.valueOf(value); break; 
			case 2: this.hurdle_quantity    = String.valueOf(value); break;
			case 3: this.food_quantity_left = String.valueOf(value); break; 
			case 4: this.food_harvested     = String.valueOf(value); break; 
			case 5: this.hurdles_avoided    = String.valueOf(value); break; 

		}
		this.table.revalidate();
		this.table.repaint();
	}

	public void launch() {
		statisticsView mainFrame	= new statisticsView();
		mainFrame.setVisible( true );
	}
	
}