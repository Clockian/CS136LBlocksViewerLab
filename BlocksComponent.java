//Created by Jasque Saydyk
//Package is used by my IDE, remove if it's a problem
package com.CS136L.Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class BlocksComponent extends JComponent{

	//This is to improve compatibility with older versions of this class
	//You can ignore this, line exists to remove IDE warning
	private static final long serialVersionUID = 1L;
	
	//Colors of the blocks
	private Color oBlockColor = Color.YELLOW;
	
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		//Creating all of the objects for snapshot with positions
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
		
		//Put all objects into array
		Tetromino[] bag = {iblock1, iblock2, sblock1, sblock2, oblock1, oblock2,
				tblock1, tblock2, lblock1, lblock2, zblock1, zblock2, jblock1, jblock2};
		
		//For each object in bag, set the color then display it, using polymorphism
		for(Tetromino block : bag){
			g2.setColor(block.getColor());
			Rectangle[] dimensions = block.getBlockArray();
			for(Rectangle shape : dimensions){	
				g2.fill(shape);
			}
		}	
	}
}