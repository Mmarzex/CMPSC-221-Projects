package org.ncg.core;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class GameWindow extends JFrame {
	private JTextArea textArea;
	public GameWindow() {
		setSize(640, 480);
		setTitle("Nittany Cubs Gaming GUI");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton westButton = new JButton("Go west");
		westButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerWest();
			}
		});
		getContentPane().add(westButton, BorderLayout.WEST);
		
		JButton northButton = new JButton("Go north");
		northButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerNorth();
			}
		});
		getContentPane().add(northButton, BorderLayout.NORTH);
		
		JButton eastButton = new JButton("Go east");
		eastButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerEast();
				
			}
		});
		getContentPane().add(eastButton, BorderLayout.EAST);
		
		JButton southButton = new JButton("Go south");
		southButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerSouth();
			}
		});
		getContentPane().add(southButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	public JTextArea textArea() {
		return textArea;
	}

}
