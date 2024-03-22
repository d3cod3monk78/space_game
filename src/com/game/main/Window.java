package com.game.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	/**
	 * @author infinityDev
	 */
	private static final long serialVersionUID = 1L;

	public Window(int width, int height, String title, Game game) {
		
		Dimension dim = new Dimension(width, height);
		
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(dim);
		frame.setMinimumSize(dim);
		frame.setMaximumSize(dim);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}
	
}
