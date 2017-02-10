/*
 * Created by Jasque Saydyk and Tyler Smith
 * Lab 03 - Painting Cars
 * CS 136L Section 3801
 * 10 February 2017
 * Description - This class creates the panel of cars to be shown
*/
package com.CS136L.PaintingCars;

import java.awt.Color;
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
		
		Car car1 = new Car(0,0);
		Car car2 = new Car(60, 30);
		CustomCar car3 = new CustomCar(120, 60);
		CustomCar car4 = new CustomCar(180, 90, 200, 10, 10, Color.CYAN);
		
		car1.draw(g2);
		car2.draw(g2);
		car3.draw(g2);
		car4.draw(g2);
	}
}
