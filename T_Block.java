package com.CS136L.Tetris;

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
