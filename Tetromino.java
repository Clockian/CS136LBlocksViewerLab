/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This interface makes the standard for all the classes to follow and
 * allows allows for polymorphism in main program
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public interface Tetromino {
	public Color getColor();
	public Rectangle[] getBlockArray();
	
	public void rotate0();
	public void rotate90();
	public void rotate180();
	public void rotate270();
}
