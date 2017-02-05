/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class describes the S block in Tetris, with each square being 20 by 20 pixels.
 * The S is composed of 2 blocks horizontal, 20 pixels down and 2 blocks horizontal, 20 pixels over
 * The blockArray is used to store the different Rectangles needed to construct the shape
 * The rotate methods redraw the shape to describe how it looks in those various positions
 * The rotate methods rotate the shape counter clock-wise
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Color;
import java.awt.Rectangle;

public class S_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockS1;
	private Rectangle blockS2;
	
	public S_Block(){
		x = 0;
		y = 0;
		blockColor = Color.GREEN;
		blockArray = new Rectangle[2];
		blockS1 = new Rectangle(x + 20, y, 2 * 20, 1 * 20);
		blockS2 = new Rectangle(x, y + 20, 2 * 20, 1 * 20);
		blockArray[0] = blockS1;
		blockArray[1] = blockS2;
	}
	
	public S_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.GREEN;
		blockArray = new Rectangle[2];
		blockS1 = new Rectangle(this.x + 20, this.y, 2 * 20, 1 * 20);
		blockS2 = new Rectangle(this.x, this.y + 20, 2 * 20, 1 * 20);
		blockArray[0] = blockS1;
		blockArray[1] = blockS2;
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
		blockS1.setBounds(x + 20, y, 2 * 20, 1 * 20);
		blockS2.setBounds(x, y + 20, 2 * 20, 1 * 20);
	}

	@Override
	public void rotate90() {
		blockS1.setBounds(x, y, 1 * 20, 2 * 20);
		blockS2.setBounds(x + 20, y + 20, 1 * 20, 2 * 20);
	}

	@Override
	public void rotate180() {
		blockS1.setBounds(x + 20, y, 2 * 20, 1 * 20);
		blockS2.setBounds(x, y + 20, 2 * 20, 1 * 20);
	}

	@Override
	public void rotate270() {
		blockS1.setBounds(x, y, 1 * 20, 2 * 20);
		blockS2.setBounds(x + 20, y + 20, 1 * 20, 2 * 20);
	}
}
