/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the I block in Tetris, with each square being 20 by 20 pixels.
 * The I is composed of 4 squares vertical.
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class I_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockI;
	
	public I_Block(){
		x = 0;
		y = 0;
		blockColor = Color.CYAN;
		blockI = new Rectangle(x, y, 1 * 20, 4 * 20);
		blockArray = new Rectangle[1];
		blockArray[0] = blockI;
	}
	
	public I_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.CYAN;
		blockI = new Rectangle(this.x, this.y, 1 * 20, 4 * 20);
		blockArray = new Rectangle[1];
		blockArray[0] = blockI;
	}
	
	@Override
	public Color getColor(){
		return blockColor;
	}
	
	@Override
	public Rectangle[] getBlockArray(){
		return blockArray;
	}

	@Override
	public void rotate0() {
		blockI.setSize(1 * 20, 4 * 20);
	}
	
	@Override
	public void rotate90() {
		blockI.setSize(4 * 20, 1 * 20);
	}

	@Override
	public void rotate180() {
		blockI.setSize(1 * 20, 4 * 20);	
	}

	@Override
	public void rotate270() {
		blockI.setSize(4 * 20, 1 * 20);
	}		
}
