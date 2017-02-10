/*
 * Created by Jasque Saydyk and Tyler Smith
 * Lab 03 - Painting Cars
 * CS 136L Section 3801
 * 10 February 2017
 * Description - This class creates a CustomCar, inheriting from Car,
 * but adding the ability to change the length, wheel size, and color
 * of the car
*/
package com.CS136L.PaintingCars;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CustomCar extends Car{
	private int carLength;  // Width of Rectangle
	private int leftWheelSize;
	private int rightWheelSize;
	private Color carColor;
	
	/**
	 * Constructs a default car with a given top left corner.
	 * @param x the x-coordinate of the top-left corner
	 * @param y the y-coordinate of the top-left corner
	 */
	public CustomCar(int x, int y) {
		super(x, y);
		carLength = 60;
		leftWheelSize = 10;
		rightWheelSize = 10;
		carColor = Color.BLACK;
	}
	
	/**
	 * Constructs a custom car with a given top left corner.
	 * @param x the x-coordinate of the top-left corner
	 * @param y the y-coordinate of the top-left corner
	 * @param carLength the length of the car, or width of the rectangle
	 * @param leftWheelSize the diameter of the left wheel
	 * @param rightWheelSize the diameter of the right wheel
	 * @param carColor the color of the body of the car
	 */
	public CustomCar(int x, int y, int carLength, int leftWheelSize, int rightWheelSize, Color carColor){
		super(x, y);
		this.carLength = carLength;
		this.leftWheelSize = leftWheelSize;
		this.rightWheelSize = rightWheelSize;
		this.carColor = carColor;
	}
	
	/**
	 * Draws the car
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2){
		Rectangle body = new Rectangle(x, y + 10, carLength, 10);
		Ellipse2D.Double leftTire
			= new Ellipse2D.Double(x + 10, y + 20, leftWheelSize, leftWheelSize);
		Ellipse2D.Double rightTire
			= new Ellipse2D.Double(x + (carLength - 20), y + 20, rightWheelSize, rightWheelSize);
		
		// The bottom of the front windshield
		Point2D.Double r1 = new Point2D.Double(x + 10, y + 10);
		// The front of the roof
		Point2D.Double r2 = new Point2D.Double(x + 20, y);
		// The rear of the roof
		Point2D.Double r3 = new Point2D.Double(x + (carLength - 20), y);
		// The bottom of the rear windshield
		Point2D.Double r4 = new Point2D.Double(x + (carLength - 10), y +10);
		
		Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
		Line2D.Double roofTop = new Line2D.Double(r2, r3);
		Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
		
		g2.setColor(carColor);
		g2.fill(body);
		g2.draw(frontWindshield);
		g2.draw(roofTop);
		g2.draw(rearWindshield);
		
		g2.setColor(Color.BLACK);
		g2.fill(leftTire);
		g2.fill(rightTire);
		
	}
}
