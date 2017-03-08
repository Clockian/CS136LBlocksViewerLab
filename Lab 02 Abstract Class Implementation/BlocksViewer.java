/*
 * Created by Jasque Saydyk and Duxing Chen
 * Lab 02 - Drawing Blocks
 * CS 136L Section 3801
 * 5 February, 2017
 * Description - This class is main, creating the window and rendering the scene
*/
import java.awt.Color;

import javax.swing.JFrame;

public class BlocksViewer {
	public static void main(String[] args){
		// Sets up JFrame
		JFrame frame = new JFrame();
		frame.setSize(10*20, 28*20);
		frame.setTitle("Tetris Snapshot");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.GRAY);
		
		// Create new component that knows how to draw blocks
		BlocksComponent shape = new BlocksComponent();
		
		// Add component to the JFrame
		frame.add(shape);
		
		// Make the frame visible so things render
		frame.setVisible(true);
	}
}
