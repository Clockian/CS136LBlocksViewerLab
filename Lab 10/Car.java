/*
 * Created by Jasque Saydyk and Austin Collins
 * Lab 10 - ControlPanel
 * CS 136L Section 3801
 * 30 April 2017
 * Description - This class is a generic car, code originates from
 * Big Java 6th edition, Chapter 3, pg. 112, with slight edits
*/

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Car {
	protected int x;
	protected int y;
	
	/**
	 * Constructs a car with a given top left corner.
	 * @param x the x-coordinate of the top-left corner
	 * @param y the y-coordinate of the top-left corner
	 */
	public Car(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws the car
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2){
		Rectangle body = new Rectangle(x, y + 10, 60, 10);
		Ellipse2D.Double leftTire
			= new Ellipse2D.Double(x + 10, y + 20, 10, 10);
		Ellipse2D.Double rightTire
			= new Ellipse2D.Double(x + 40, y + 20, 10, 10);
		
		// The bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(x + 10, y + 10);
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(x + 20, y);
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(x + 40, y);
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(x + 50, y +10);
		
		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		
		g2.draw(body);
		g2.draw(leftTire);
		g2.draw(rightTire);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
	}
}
