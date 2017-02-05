/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the Z block in Tetris, with each square being 20 by 20 pixels.
 * The Z is composed of 2 blocks horizontal and 2 blocks horizontal, 20 pixels over and down
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class Z_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockZ1;
	private Rectangle blockZ2;
	
	public Z_Block(){
		x = 0;
		y = 0;
		blockColor = Color.RED;
		blockArray = new Rectangle[2];
		blockZ1 = new Rectangle(x, y, 2 * 20, 1 * 20);
		blockZ2 = new Rectangle(x + 20, y + 20, 2 * 20, 1 * 20);
		blockArray[0] = blockZ1;
		blockArray[1] = blockZ2;
	}
	
	public Z_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.RED;
		blockArray = new Rectangle[2];
		blockZ1 = new Rectangle(this.x, this.y, 2 * 20, 1 * 20);
		blockZ2 = new Rectangle(this.x + 20, this.y + 20, 2 * 20, 1 * 20);
		blockArray[0] = blockZ1;
		blockArray[1] = blockZ2;
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
		blockZ1.setBounds(x, y, 2 * 20, 1 * 20);
		blockZ2.setBounds(x + 20, y + 20, 2 * 20, 1 * 20);
	}

	@Override
	public void rotate90() {
		blockZ1.setBounds(x, y + 20, 1 * 20, 2 * 20);
		blockZ2.setBounds(x + 20, y, 1 * 20, 2 * 20);	
	}

	@Override
	public void rotate180() {
		blockZ1.setBounds(x, y, 2 * 20, 1 * 20);
		blockZ2.setBounds(x + 20, y + 20, 2 * 20, 1 * 20);
	}

	@Override
	public void rotate270() {
		blockZ1.setBounds(x, y + 20, 1 * 20, 2 * 20);
		blockZ2.setBounds(x + 20, y, 1 * 20, 2 * 20);
	}
}
