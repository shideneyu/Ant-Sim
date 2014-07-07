package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StatisticsView extends JPanel {
  // Instance attributes used in this example
  private JPanel    topPanel;
  private JTable    table;
  private JScrollPane scrollPane;
  private String hurdle_quantity    = "20";
  private String ant_current_number = "20";
  private int hurdles_avoided    = 0;
  private String food_harvested     = "20";
  private String food_quantity_left = "20";
  JTextField foodHarvestedField;
  JTextField hurdleAvoidedField;

  
  // Constructor of main frame
  public StatisticsView() {
	  JPanel p = new JPanel(new SpringLayout());
	  // Food harvested
	  JLabel l = new JLabel("Food Harvested: ", JLabel.TRAILING);
      p.add(l);
      this.foodHarvestedField = new JTextField(10);
      l.setLabelFor(this.foodHarvestedField);
      p.add(this.foodHarvestedField);
      // Hurdle avoided
	  JLabel hurdle = new JLabel("Hurdle Avoided: ", JLabel.TRAILING);
      p.add(hurdle);
      this.hurdleAvoidedField = new JTextField(10);
      hurdle.setLabelFor(this.hurdleAvoidedField);
      p.add(this.hurdleAvoidedField);
	  //Lay out the panel.
	  SpringUtilities.makeCompactGrid(p, 1, p.getComponentCount(), 6, 6, 6, 6);
	
	  //Create and set up the window.
	  JFrame frame = new JFrame("Ant-Sim Configuration");
	  //Set up the content pane.
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	  p.setOpaque(true);  //content panes must be opaque
	  frame.setContentPane(p);
	
	  //Display the window.
	  frame.pack();
	  frame.setVisible(true);
  }

  private Object[][] getDataValues() {
	  String dataValues[][] =
   {
     { this.ant_current_number, this.hurdle_quantity, this.food_quantity_left, this.food_harvested, this.food_harvested, String.valueOf(this.hurdles_avoided) }
   };
   return dataValues;
  }

  public void setDataValues(int position, int value) {
    switch (position) { 
     case 1: this.ant_current_number = String.valueOf(value); break; 
     case 2: this.hurdle_quantity    = String.valueOf(value); break;
     case 3: this.food_quantity_left = String.valueOf(value); break; 
     case 4: this.food_harvested     = String.valueOf(value); break; 
     case 5: this.hurdles_avoided    = value; break; 
    }
    this.foodHarvestedField.setText(this.food_harvested);
    this.hurdleAvoidedField.setText(String.valueOf(this.hurdles_avoided));

  }
}