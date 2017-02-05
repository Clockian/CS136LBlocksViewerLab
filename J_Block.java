package com.CS136L.Tetris;

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
