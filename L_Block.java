package com.CS136L.Tetris;

import java.awt.Color;
import java.awt.Rectangle;

public class L_Block implements Tetromino{
	private int x;
	private int y;
	private Color blockColor;	
	private Rectangle[] blockArray;
	private Rectangle blockL1;
	private Rectangle blockL2;
	
	public L_Block(){
		x = 0;
		y = 0;
		blockColor = Color.ORANGE;
		blockArray = new Rectangle[2];
		blockL1 = new Rectangle(x, y, 1 * 20, 3 * 20);
		blockL2 = new Rectangle(x + 20, y + 40, 1 * 20, 1 * 20);
		blockArray[0] = blockL1;
		blockArray[1] = blockL2;
	}
	
	public L_Block(int x, int y){
		this.x = x;
		this.y = y;
		blockColor = Color.ORANGE;
		blockArray = new Rectangle[2];
		blockL1 = new Rectangle(this.x, this.y, 1 * 20, 3 * 20);
		blockL2 = new Rectangle(this.x + 20, this.y + 40, 1 * 20, 1 * 20);
		blockArray[0] = blockL1;
		blockArray[1] = blockL2;
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
		blockL1.setBounds(x, y, 1 * 20, 3 * 20);
		blockL2.setBounds(x + 20, y + 40, 1 * 20, 1 * 20);
	}

	@Override
	public void rotate90() {
		blockL1.setBounds(x, y + 20, 3 * 20, 1 * 20);
		blockL2.setBounds(x + 40, y, 1 * 20, 1 * 20);
	}

	@Override
	public void rotate180() {
		blockL1.setBounds(x + 20, y, 1 * 20, 3 * 20);
		blockL2.setBounds(x, y, 1 * 20, 1 * 20);	
	}

	@Override
	public void rotate270() {
		blockL1.setBounds(x, y, 3 * 20, 1 * 20);
		blockL2.setBounds(x, y + 20, 1 * 20, 1 * 20);
	}

}
