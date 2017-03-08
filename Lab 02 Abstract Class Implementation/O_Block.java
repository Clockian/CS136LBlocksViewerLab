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
import java.awt.Color;
import java.awt.Rectangle;

public class O_Block extends Tetromino{
	
	public O_Block(){
		super();
		x = 0;
		y = 0;
		blockColor = Color.YELLOW;
		blockArray = new Rectangle[1];
		block = new Rectangle(x, y, 2 * 20, 2 * 20);
		blockArray[0] = block;
	}
	
	public O_Block(int x, int y){
		super();
		this.x = x;
		this.y = y;
		blockColor = Color.YELLOW;
		blockArray = new Rectangle[1];
		block = new Rectangle(this.x, this.y, 2 * 20, 2 * 20);
		blockArray[0] = block;
	}

	@Override
	public void rotate0() {
		block.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate90() {
		block.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate180() {
		block.setBounds(x, y, 2 * 20, 2 * 20);
	}

	@Override
	public void rotate270() {
		block.setBounds(x, y, 2 * 20, 2 * 20);
	}
}
