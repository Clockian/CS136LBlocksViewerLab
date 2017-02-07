/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the J block in Tetris, with each square being 20 by 20 pixels.
 * The J is composed of 3 squares vertical and 1 square to the left of the bottom square forming a backwards L.
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class J_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockJ1;
	private Rectangle blockJ2;
	
	public J_Block(){
		x = 0;
		y = 0;
		blockColor = Color.BLUE;
		blockArray = new Rectangle[2];
		blockJ1 = new Rectangle(x + 20, y, 1 * 20, 3 * 20);
		blockJ2 = new Rectangle(x, y + 40, 20, 20);
		blockArray[0] = blockJ1;
		blockArray[1] = blockJ2;
	}
	
	public J_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.BLUE;
		blockArray = new Rectangle[2];
		blockJ1 = new Rectangle(this.x + 20, this.y, 1 * 20, 3 * 20);
		blockJ2 = new Rectangle(this.x, this.y + 40, 20, 20);
		blockArray[0] = blockJ1;
		blockArray[1] = blockJ2;
	}
	
	@Override
	public Color getColor() {
		return blockColor;
	}

	@Override
	public Rectangle[] getBlockArray() {
		return blockArray;
	}

	@Override
	public void rotate0() {
		blockJ1.setBounds(x + 20, y, 1 * 20, 3 * 20);
		blockJ2.setBounds(x, y + 40, 20, 20);
	}

	@Override
	public void rotate90() {
		blockJ1.setBounds(x, y, 3 * 20, 1 * 20);
		blockJ2.setBounds(x + 40, y + 20, 20, 20);
	}

	@Override
	public void rotate180() {
		blockJ1.setBounds(x, y, 1 * 20, 3 * 20);
		blockJ2.setBounds(x + 20, y, 20, 20);
	}

	@Override
	public void rotate270() {
		blockJ1.setBounds(x, y + 20, 3 * 20, 1 * 20);
		blockJ2.setBounds(x, y, 20, 20);
	}

}
