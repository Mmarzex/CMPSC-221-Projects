	package org.ncg.core;

/**
 * This class represents a player of the adventure game.
 */
public class Player extends Entity
{
	/**
	 * Moves the player in the specified direction
	 * @param direction - The direction to move
	 */
	protected void move(String direction) {
		
		try
		{
			Location newLocation = null;
			if(direction == "east")
				newLocation = Application.instance().determineLocationEastOf(currentLocation);
			else if(direction == "west")
				newLocation = Application.instance().determineLocationWestOf(currentLocation);
			else if(direction == "north")
				newLocation = Application.instance().determineLocationNorthOf(currentLocation);
			else if(direction == "south")
				newLocation = Application.instance().determineLocationSouthOf(currentLocation);
			else 
				informInvalidGoDirectionObservers(direction);
			currentLocation(newLocation);
			informPlayerMovedObservers();
		}
		catch (NoLocationInDirectionException e)
		{
			informInvalidGoDirectionObservers(direction);
		} /* end try */
	
	}
	
	/**
	 * Attempt to move the player to the east from their current location
	 */
	protected void goEast()
	{
		move("east");
	} /* end goEast */
	
	/**
	 * Attempt to move the player to the north from their current location
	 */
	protected void goNorth()
	{
		move("north");
	} /* end goNorth */
	
	/**
	 * Attempt to move the player to the south from their current location
	 */
	protected void goSouth()
	{
		move("south");
	} /* end goSouth */
	
	/**
	 * Attempt to move the player to the west from their current location
	 */
	protected void goWest()
	{
		move("west");
	} /* end goWest */

	/**
	 * Inform any/all observers that the player attempted to go an invalid
	 * direction
	 * @param direction - The invalid direction the player tried to go
	 */
	protected void informInvalidGoDirectionObservers(String direction)
	{
		Application.instance().informInvalidGoDirectionObservers(direction);
	} /* end informInvalidGoDirectionObservers */
	
	/**
	 * Inform any/all observers that the player has moved
	 */
	protected void informPlayerMovedObservers()
	{
		Application.instance().informPlayerMovedObservers();
	} /* end informPlayerMovedObservers */
} /* end Player */
