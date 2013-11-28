package org.ncg.core;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class GameWindow extends JFrame {
	
	public JTextArea textArea;
	
	public GameWindow() {
		setSize(640, 480);
		setTitle("Nittany Cubs Gaming GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Go west");
		getContentPane().add(btnNewButton, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton("Go north");
		getContentPane().add(btnNewButton_1, BorderLayout.NORTH);
		
		JButton btnNewButton_2 = new JButton("Go east");
		getContentPane().add(btnNewButton_2, BorderLayout.EAST);
		
		JButton btnNewButton_3 = new JButton("Go south");
		getContentPane().add(btnNewButton_3, BorderLayout.SOUTH);
	}

}
