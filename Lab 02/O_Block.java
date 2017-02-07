/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the O block in Tetris, with each square being 20 by 20 pixels.
 * The O is composed of 4 squares, 2 vertical and 2 horizontal forming a 2 by 2 square.
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class O_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockO;
	
	public O_Block(){
		x = 0;
		y = 0;
		blockColor = Color.YELLOW;
		blockArray = new Rectangle[1];
		blockO = new Rectangle(x, y, 2 * 20, 2 * 20);
		blockArray[0] = blockO;
	}
	
	public O_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.YELLOW;
		blockArray = new Rectangle[1];
		blockO = new Rectangle(this.x, this.y, 2 * 20, 2 * 20);
		blockArray[0] = blockO;
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
		blockO.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate90() {
		blockO.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate180() {
		blockO.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate270() {
		blockO.setBounds(x, y, 2 * 20, 2 * 20);
	}
}
