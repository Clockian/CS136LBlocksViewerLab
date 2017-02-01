//Created by Jasque Saydyk
//Package is used by my IDE, remove if it's a problem
package com.CS136L.Tetris;

import java.awt.Color;

import javax.swing.JFrame;

public class BlocksViewer {
	public static void main(String[] args){
		//Sets up JFrame
		JFrame frame = new JFrame();
		frame.setSize(10*20, 26*20);
		frame.setTitle("Tetris Snapshot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.GRAY);
		
		//Create new component that knows how to draw blocks
		BlocksComponent shape = new BlocksComponent();
		
		//Add component to the JFrame
		frame.add(shape);
		
		//Make the frame visible so things render
		frame.setVisible(true);
	}
}
