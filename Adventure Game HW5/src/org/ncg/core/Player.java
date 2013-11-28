package org.ncg.core;

/**
 * This class represents a player of the adventure game.
 */
public class Player extends Entity
{
	/**
	 * Move the player to the specified location
	 * @param value - The new location where the player will be moved
	 */
	protected void currentLocation(Location value)
	{
		super.currentLocation(value);
		informPlayerMovedObservers();
	} /* end currentLocation */	

	/**
	 * Attempt to move the player to the east from their current location
	 */
	protected void goEast()
	{
		try
		{
   		Location newLocation = Application.instance().determineLocationEastOf(currentLocation());
	   	currentLocation(newLocation);
		}
		catch (NoLocationInDirectionException e)
		{
			informInvalidGoDirectionObservers("east");
		} /* end try */
	} /* end goEast */
	
	/**
	 * Attempt to move the player to the north from their current location
	 */
	protected void goNorth()
	{
		try
		{
   		Location newLocation = Application.instance().determineLocationNorthOf(currentLocation());
	   	currentLocation(newLocation);
		}
		catch (NoLocationInDirectionException e)
		{
			informInvalidGoDirectionObservers("north");
		} /* end try */
	} /* end goNorth */
	
	/**
	 * Attempt to move the player to the south from their current location
	 */
	protected void goSouth()
	{
		try
		{
   		Location newLocation = Application.instance().determineLocationSouthOf(currentLocation());
	   	currentLocation(newLocation);
		}
		catch (NoLocationInDirectionException e)
		{
			informInvalidGoDirectionObservers("south");
		} /* end try */
	} /* end goSouth */
	
	/**
	 * Attempt to move the player to the west from their current location
	 */
	protected void goWest()
	{
		try
		{
   		Location newLocation = Application.instance().determineLocationWestOf(currentLocation());
	   	currentLocation(newLocation);
		}
		catch (NoLocationInDirectionException e)
		{
			informInvalidGoDirectionObservers("west");
		} /* end try */
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

	/** The "version" of this object's state, required by Serializable */
	private static final long serialVersionUID = 1L;
} /* end Player */
