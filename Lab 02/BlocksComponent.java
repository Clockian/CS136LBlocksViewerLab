/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class dictates what is actually rendered in the scene
*/
package com.CS136L.Tetris;  // Package is used by my IDE, remove if it's a problem

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class BlocksComponent extends JComponent{

	// This is to improve compatibility with older versions of this class
	// You can ignore this, line exists to remove IDE warning
	private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g){
		// Casting(converting) Graphics to Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		
		// Creating all of the objects for snapshot with positions, then rotating if necessary
		I_Block iblock1 = new I_Block(0, 25 * 20);
		iblock1.rotate90();
		I_Block iblock2 = new I_Block(8 * 20, 17 * 20);
		S_Block sblock1 = new S_Block(3 * 20, 23 * 20);
		sblock1.rotate90();
		S_Block sblock2 = new S_Block(5 * 20, 21 * 20);
		sblock2.rotate90();
		O_Block oblock1 = new O_Block(5 * 20, 24 * 20);
		O_Block oblock2 = new O_Block(7 * 20, 21 * 20);
		T_Block tblock1 = new T_Block(7 * 20, 23 * 20);
		tblock1.rotate270();
		T_Block tblock2 = new T_Block(6 * 20, 18 * 20);
		tblock2.rotate270();
		L_Block lblock1 = new L_Block(0, 19 * 20);
		L_Block lblock2 = new L_Block(4 * 20, 21 * 20);
		Z_Block zblock1 = new Z_Block(0,23 * 20);
		Z_Block zblock2 = new Z_Block(1 * 20, 20 * 20);
		J_Block jblock1 = new J_Block(0 ,22 * 20);
		jblock1.rotate90();
		J_Block jblock2 = new J_Block(4 * 20, 20 * 20);
		jblock2.rotate90();
		
		// Put all objects into array
		Tetromino[] bag = {iblock1, iblock2, sblock1, sblock2, oblock1, oblock2,
				tblock1, tblock2, lblock1, lblock2, zblock1, zblock2, jblock1, jblock2};
		
		/*
		 * For each object in bag, set the color then display it, using polymorphism
		 * Specifically what it does is that, since each shape could only be made with 
		 * the Rectangle class, I had each object store the Rectangles needed to create 
		 * it in an array. BlockComponent then takes the array from the class, then displays 
		 * each rectangle in the array.
		*/
		for(Tetromino block : bag){
			g2.setColor(block.getColor());
			Rectangle[] dimensions = block.getBlockArray();
			for(Rectangle shape : dimensions){	
				g2.fill(shape);
			}
		}	
	}
}