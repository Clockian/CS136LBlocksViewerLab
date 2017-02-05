package com.CS136L.Tetris;

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
