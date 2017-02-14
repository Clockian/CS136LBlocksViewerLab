/*
 * Created by Jasque Saydyk and Tyler Smith
 * Lab 03 - Painting Cars
 * CS 136L Section 3801
 * 11 February 2017
 * Description - This class creates a paint bucket, initially
 * filled with white paint. To change the color, you add paint
 * of different colors in different amounts called parts
*/
package com.CS136L.PaintingCars;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;

public class PaintBucket {
	private int originalParts;
	private int originalRed;
	private int originalGreen;
	private int originalBlue;
	private Color bucket;
	
	/**
	 * Constructs a default PaintBucket filled with white paint.
	 */
	public PaintBucket(){
		originalParts = 1;
		originalRed = 255;
		originalGreen = 255;
		originalBlue = 255;
	}
	
	/**
	 * Returns the current color in the paint bucket
	 * @return Color object with current color
	 */
	public Color getColor(){
		return bucket;
	}
	
	/**
	 * Add paint of specified amount and color to the paint bucket
	 * @param additiveParts the amount of paint to add to bucket
	 * @param additiveRed the Red of the RGB color being added
	 * @param additiveGreen the Green of the RGB color being added
	 * @param additiveBlue the Blue of the RGB color being added
	 */
	public void addColor(int additiveParts, int additiveRed, int additiveGreen, int additiveBlue){
		int averageRed;
		int averageGreen;
		int averageBlue;
		
		// Takes the average of the paint being added and the original paint to get the new color
		averageRed = (((additiveParts * additiveRed) + (originalParts * originalRed))/
					   (additiveParts + originalParts));
		averageGreen = (((additiveParts * additiveGreen) + (originalParts * originalGreen))/
						 (additiveParts + originalParts));
		averageBlue = (((additiveParts * additiveBlue) + (originalParts * originalBlue))/
						(additiveParts + originalParts));
		
		// New color created
		bucket = new Color(averageRed, averageGreen, averageBlue);
	}
}
