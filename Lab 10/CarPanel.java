/*
 * Created by Jasque Saydyk and Tyler Smith
 * Lab 03 - Painting Cars
 * CS 136L Section 3801
 * 10 February 2017
 * Description - This class creates the panel of cars to be shown
*/
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class CarPanel extends JPanel{
	
	// Used for version control
	private static final long serialVersionUID = 1L;
	
	/**
	 * Creates the panel to be shown
	 * @param g the graphics context
	 */
	public void paintComponent(Graphics g){
		
		Graphics2D g2 = (Graphics2D) g;
		
		PaintBucket bucket = new PaintBucket();
		
		CustomCar car1 = new CustomCar(0, 0, 40, 10, 10, bucket.getColor());
		
		bucket.addColor(3, 160, 200, 30);
		
		CustomCar car2 = new CustomCar(0, 50, 60, 20, 15, bucket.getColor());
		
		bucket.addColor(5, 20, 255, 200);
		
		CustomCar car3 = new CustomCar(0, 100, 150, 5, 5, bucket.getColor());
		
		bucket.addColor(2, 255, 100, 150);
		
		CustomCar car4 = new CustomCar(0, 150, 200, 10, 10, bucket.getColor());
		
		car1.draw(g2);
		car2.draw(g2);
		car3.draw(g2);
		car4.draw(g2);
	}
}
