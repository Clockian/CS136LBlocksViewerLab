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
	
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle block_t1 = new Rectangle(20, 0, 80, 20);
		Rectangle block_t2 = new Rectangle(0, 20, 60, 20);
		
		g2.setColor(Color.CYAN);
		
		g2.fill(block_t1);
		g2.fill(block_t2);
	}

}
