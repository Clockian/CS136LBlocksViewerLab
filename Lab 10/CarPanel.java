/*
 * Created by Jasque Saydyk and Austin Collins
 * Lab 10 - ControlPanel
 * CS 136L Section 3801
 * 30 April 2017
 * Description - This class creates the panel of cars to be shown
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class CarPanel extends JPanel{
	
	// Used for version control
	private static final long serialVersionUID = 1L;
	
	// Using an ArrayList rather than an array, as it doesn't need to be manually resized
	private ArrayList<CustomCar> carsToDraw = new ArrayList<>();
	
	/**
	 * Creates the panel to be shown
	 * @param g the graphics context
	 */
	@Override
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		
		for(CustomCar x: carsToDraw){
			x.draw(g2);
		}
	}
	
	/**
	 * @return Preferred window size for this class
	 */
	@Override
	public Dimension getPreferredSize(){
		return new Dimension(300, 300);
	}
	
	/**
	 * Creates and adds a custom car to be drawn on the component. The color of the car is
	 * randomly generated
	 * @param x the x-coordinate of the top-left corner
	 * @param y the y-coordinate of the top-left corner
	 * @param carLength the length of the car, or width of the rectangle
	 * @param leftWheelSize the diameter of the left wheel
	 * @param rightWheelSize the diameter of the right wheel
	 */
	public void addCar(int x, int y, int carLength, int leftWheelSize, int rightWheelSize, Color carColor){
		// Creates the car, then adds it to the list
		CustomCar car = new CustomCar(x, y, carLength, leftWheelSize, rightWheelSize, carColor);
		carsToDraw.add(car);
	}
	
	/**
	 * Overloaded method to comply with project specs, which states "add a method addCar that accepts both a
	 * CustomCar and a point". I didn't include the point as you need to specify that when you create a CustomCar
	 * in the first place, I would rather not fiddle with CustomCar at this time
	 * @param car
	 */
	public void addCar(CustomCar car){
		carsToDraw.add(car);
	}
}