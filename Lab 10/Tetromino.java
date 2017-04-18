/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This interface makes the standard for all the classes to follow and
 * allows allows for polymorphism in main program
*/
import java.awt.Color;
import java.awt.Rectangle;

abstract public class Tetromino {
	protected int x;
	protected int y;
	protected Color blockColor;
	protected Rectangle[] blockArray;
	protected Rectangle block;
	
	public Color getColor(){
		return blockColor;
	}
	
	public Rectangle[] getBlockArray(){
		return blockArray;
	}
	
	abstract public void rotate0();
	abstract public void rotate90();
	abstract public void rotate180();
	abstract public void rotate270();
}
