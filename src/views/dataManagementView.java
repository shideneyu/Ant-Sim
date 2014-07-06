package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

public class dataManagementView  extends JPanel {

    private List<JTextField> listOfTextFields = new ArrayList<JTextField>();

	public dataManagementView() {
		String[] labels = {"Ant Number: ", "Hurdle Quantity: ", "Food Quantity: ", "Timer (ms): "};
	    int numPairs = labels.length;

	    //Create and populate the panel.
	    JPanel p = new JPanel(new SpringLayout());
	    for (int i = 0; i < numPairs; i++) {
	        JLabel l = new JLabel(labels[i], JLabel.TRAILING);
	        p.add(l);
	        JTextField textField = new JTextField(10);
	        listOfTextFields.add(textField);
	        l.setLabelFor(textField);
	        p.add(textField);
	    }
	    JButton button = new JButton("Valider");
	    
	    button.addActionListener(new ActionListener() {
	    	 
	        public void actionPerformed(ActionEvent e)
	        {
	        	GroundView myGroundView = new GroundView();
	        	myGroundView.setAntNumber(Integer.valueOf(listOfTextFields.get(0).getText()));
	        	myGroundView.setHurdleQuantity(Integer.valueOf(listOfTextFields.get(1).getText()));
	        	myGroundView.setFoodQuantity(Integer.valueOf(listOfTextFields.get(2).getText()));
	        	myGroundView.setTimerPause(Integer.valueOf(listOfTextFields.get(3).getText()));
	        	startSimulation(myGroundView);
	        	//Execute when button is pressed
	        }
	    });   
	    p.add(button);
	    
	    //Lay out the panel.
	      SpringUtilities.makeCompactGrid(p, 1, p.getComponentCount(), 6, 6, 6, 6);

	    //Create and set up the window.
	    JFrame frame = new JFrame("AntSimulator Options");
	    //Set up the content pane.
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    p.setOpaque(true);  //content panes must be opaque
	    frame.setContentPane(p);

	    //Display the window.
	    frame.pack();
	    frame.setVisible(true);
	}
    	
		
	
	public void startSimulation(final GroundView myGroundView) {
		SwingUtilities.invokeLater(new Runnable() {
    	     public void run() {
   		        myGroundView.getStatisticsPanel();

 		        JFrame frame = new JFrame();
 		        frame.setSize(500, 500);
 		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		        frame.setVisible(true);
 		        frame.add(myGroundView);
 		        
    	     }
    	});
	}

}
