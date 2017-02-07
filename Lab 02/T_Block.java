/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the T block in Tetris, with each square being 20 by 20 pixels.
 * The T is composed of 3 blocks horizontal, and 1 block 20 pixels down and across forming a squashed T
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class T_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockT1;
	private Rectangle blockT2;
	
	public T_Block() {
		x = 0;
		y = 0;
		blockColor = new Color(128, 0, 128);
		blockArray = new Rectangle[2];
		blockT1 = new Rectangle(x, y, 3 * 20, 1 * 20);
		blockT2 = new Rectangle(x + 20, y + 20, 1 * 20, 1 * 20);
		blockArray[0] = blockT1;
		blockArray[1] = blockT2;
	}
	
	public T_Block(int x, int y) {
		this.x = x;
		this.y = y;
		blockColor = new Color(128, 0, 128);
		blockArray = new Rectangle[2];
		blockT1 = new Rectangle(this.x, this.y, 3 * 20, 1 * 20);
		blockT2 = new Rectangle(this.x + 20, this.y + 20, 1 * 20, 1 * 20);
		blockArray[0] = blockT1;
		blockArray[1] = blockT2;
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
		blockT1.setBounds(x, y, 3 * 20, 1 * 20);
		blockT2.setBounds(x + 20, y + 20, 1 * 20, 1 * 20);
	}
	
	@Override
	public void rotate90() {
		blockT1.setBounds(x, y, 1 * 20, 3 * 20);
		blockT2.setBounds(x + 20, y + 20, 1 * 20, 1 * 20);
	}

	@Override
	public void rotate180() {
		blockT1.setBounds(x, y + 20, 3 * 20, 1 * 20);
		blockT2.setBounds(x + 20, y, 1 * 20, 1 * 20);
	}

	@Override
	public void rotate270() {
		blockT1.setBounds(x + 20, y, 1 * 20, 3 * 20);
		blockT2.setBounds(x, y + 20, 1 * 20, 1 * 20);
	}
}
