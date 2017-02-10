/*
 * Created by Jasque Saydyk and Tyler Smith
 * Lab 03 - Painting Cars
 * CS 136L Section 3801
 * 10 February 2017
 * Description - This class is main, creating the window and displaying the panel
*/
package com.CS136L.PaintingCars;

import java.awt.Color;
import javax.swing.JFrame;

public class CarViewer {
	public static void main(String[] args){
		// Sets up JFrame
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setTitle("Custom Car Snapshot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.GRAY);
		
		// Creates panel in JFrame to display CarPanel
		frame.setContentPane(new CarPanel());
		
		// Make the frame visible so things render
		frame.setVisible(true);
	}
}