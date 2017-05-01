/*
 * Created by Jasque Saydyk and Austin Collins
 * Lab 10 - ControlPanel
 * CS 136L Section 3801
 * 30 April 2017
 * Description - This class creates the window for the cars to be shown
 * The entire class never extends anything so that it is forced to use
 * Composition techniques to get the job done
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarFrame{
	
	private JFrame window;
	private JSplitPane splitPane;
	
	private JSlider carWidthSlider;
	private JLabel carWidthLabel;
	private int carWidthCurrent = 60;
	
	private JSlider frontTireSlider;
	private JLabel frontTireLabel;
	private int frontTireCurrent = 10;
	
	private JSlider backTireSlider;
	private JLabel backTireLabel;
	private int backTireCurrent = 10;
	
	private JLabel colorLabel;
	private JButton chooseColorButton;
	private Color newColor;
	
	private JLabel xLabel;
	private TextField xField;
	private int xCoordinate = 0;
	
	private JLabel yLabel;
	private TextField yField;
	private int yCoordinate = 0;
	
	private JButton addCarButton;
	
	public CarFrame(){
		window = new JFrame();
		
		CarPanel carContent = new CarPanel();
		JPanel carManipulator = new JPanel();
		
		//Create a split pane with the two scroll panes in it.
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, carManipulator, carContent);
		splitPane.setDividerLocation(200);
		
		// Car Width/Length Slider
		carWidthLabel = new JLabel("Car Width: ", JLabel.LEFT);
		carWidthSlider = new JSlider(JSlider.HORIZONTAL, 40, 240, 60);
		carWidthSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				carWidthCurrent = carWidthSlider.getValue();
			}
		});
		
		// Left tire(Front) Slider
		frontTireLabel = new JLabel("Front Tire: ", JLabel.LEFT);
		frontTireSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
		frontTireSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				frontTireCurrent = frontTireSlider.getValue();
			}
		});
		
		// Right tire(Back) Slider
		backTireLabel = new JLabel("Back Tire: ", JLabel.LEFT);
		backTireSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 10);
		backTireSlider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e){
				backTireCurrent = backTireSlider.getValue();
			}
		});
		
		// Custom Color Choice
		colorLabel = new JLabel("  Color:   ", JLabel.LEFT);
		chooseColorButton = new JButton("Choose Color");
		chooseColorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent aActionEvent){
				JLabel banner = new JLabel("Choose a color", JLabel.LEFT);
				newColor = JColorChooser.showDialog(carManipulator, "Choose Background Color", banner.getBackground());
			}
		});
		
		// X Coordinate Text Field
		xLabel = new JLabel("  X:    ", JLabel.CENTER);
		xField = new TextField(15);
		
		// Y Coordinate Text Field
		yLabel = new JLabel("  Y:    ", JLabel.LEFT);
		yField = new TextField(15);		
		
		// Add Button, handles empty Text Fields, adds new Car, then paints window with new car
		addCarButton = new JButton("ADD");
		addCarButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent aActionEvent){
				if(xField.getText().isEmpty())
					xCoordinate = 0;
				else
					xCoordinate = Integer.parseInt(xField.getText());
				
				if(yField.getText().isEmpty())
					yCoordinate = 0;
				else
					yCoordinate = Integer.parseInt(yField.getText());
				
				carContent.addCar(xCoordinate, yCoordinate, carWidthCurrent, frontTireCurrent, backTireCurrent, newColor);
				window.setContentPane(splitPane);
			}
		});
		
		// Adding all of the components defined above into the window
		carManipulator.add(carWidthLabel);
		carManipulator.add(carWidthSlider);
		
		carManipulator.add(frontTireLabel);
		carManipulator.add(frontTireSlider);
		
		carManipulator.add(backTireLabel);
		carManipulator.add(backTireSlider);
		
		carManipulator.add(colorLabel);
		carManipulator.add(chooseColorButton);
		
		carManipulator.add(xLabel);
		carManipulator.add(xField);
		carManipulator.add(yLabel);
		carManipulator.add(yField);
		
		carManipulator.add(addCarButton);
		
		// Setups the panels in JFrame
		window.setContentPane(splitPane);

        // Custom JFrame settings
        window.setTitle("Custom Car Drawing");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setLocationRelativeTo(null);
        // Necessary to make window correct size, if done without, will be long and only other
        // solution is to make the getPreferredSize() method in CarComponent (-800, 300)
        window.setSize(new Dimension(500, 300));  
        window.setVisible(true);
	}
}
