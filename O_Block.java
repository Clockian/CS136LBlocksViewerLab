package com.CS136L.Tetris;

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
