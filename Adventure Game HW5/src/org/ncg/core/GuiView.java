package org.ncg.core;

public class GuiView extends View {
	private GameWindow mainWindow;
	public GuiView() {
		
		mainWindow = new GameWindow();
		mainWindow.setVisible(true);
	}
	
	@Override
	public void informInvalidGoDirection(String direction) {
		// TODO Auto-generated method stub
		mainWindow.textArea.setText("You hit your nose on the wall trying to go " + direction);
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
	   	mainWindow.textArea.setText(areaText);
	}

}
