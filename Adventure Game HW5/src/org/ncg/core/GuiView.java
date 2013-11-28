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
	   	mainWindow.textArea.setText(currentLocation.description() +
   			             getItemsDescription(currentLocation) +
   			             getMobsDescription(currentLocation) +
   			             getCanMoveDirectionsDescription(currentLocation));
	}

}
