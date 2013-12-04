package org.ncg.core;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GuiView extends View {
	private JFrame mainWindow;
	private JTextArea textArea;
	
	/**
	 * initializes the window and then sets it to be visible
	 */
	public GuiView() {
		
		initialize();
		mainWindow.setVisible(true);
	}

	/**
	 *  Initializes the window and adds all event listeners to the buttons
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setSize(640, 480);
		mainWindow.setTitle("Nittany Cubs Gaming GUI");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		JButton westButton = new JButton("Go west");
		westButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerWest();
			}
		});
		mainWindow.getContentPane().add(westButton, BorderLayout.WEST);
		
		JButton northButton = new JButton("Go north");
		northButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerNorth();
			}
		});
		mainWindow.getContentPane().add(northButton, BorderLayout.NORTH);
		
		JButton eastButton = new JButton("Go east");
		eastButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerEast();
				
			}
		});
		mainWindow.getContentPane().add(eastButton, BorderLayout.EAST);
		
		JButton southButton = new JButton("Go south");
		southButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Application.instance().movePlayerSouth();
			}
		});
		mainWindow.getContentPane().add(southButton, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		mainWindow.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	@Override
	public void informInvalidGoDirection(String direction) {
		// TODO Auto-generated method stub
		textArea.append(System.lineSeparator() + "You hit your nose on the wall trying to go " + direction);
	}

	@Override
	public void informPlayerMoved() {
		// TODO Auto-generated method stub
		look();
	}

	@Override
	public void look() {
		// TODO Auto-generated method stub
	   	Location currentLocation = Application.instance().playerCurrentLocation();
	   	String areaText = currentLocation.description() + System.lineSeparator() +
		             getItemsDescription(currentLocation) + System.lineSeparator() +
		             getMobsDescription(currentLocation) + System.lineSeparator() +
		             getCanMoveDirectionsDescription(currentLocation);
	   	textArea.setText(areaText);
	}

}
