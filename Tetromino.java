//Created by Jasque Saydyk
//Package is used by my IDE, remove if it's a problem
//This interface makes the standard for all the classes to follow and
//allows allows for polymorphism in main program
package com.CS136L.Tetris;

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
