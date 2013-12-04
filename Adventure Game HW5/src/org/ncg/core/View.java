package org.ncg.core;

public abstract class View
{
	/**
	 * Observer callback for when the player attempts to go an invalid direction
	 * from their current location
	 * @param direction - The direction the player tried to go
	 */
	public abstract void informInvalidGoDirection(String direction);

	/**
	 * Observer callback for when the player has moved (ie changed location)
	 */
	public abstract void informPlayerMoved();
	
	/**
	 * Tell the player where they are.
	 */
   public abstract void look();
   
   /**
	 * Build a description of the various directions the player can go given the
	 * current location
	 * @return
	 */
	protected String getCanMoveDirectionsDescription(Location currentLocation)
	{
		String description = "";
		
		if (Application.instance().isThereALocationEastOf(currentLocation))
		{
			description = description + " There is an exit to the east.";
		} /* end if */
		
		if (Application.instance().isThereALocationNorthOf(currentLocation))
		{
			description = description + " There is an exit to the north.";
		} /* end if */
		
		if (Application.instance().isThereALocationSouthOf(currentLocation))
		{
			description = description + " There is an exit to the south.";
		} /* end if */
		
		if (Application.instance().isThereALocationWestOf(currentLocation))
		{
			description = description + " There is an exit to the west.";
		} /* end if */
		
		return(description);
	} /* end getCanMoveDirectionsDescription */
	
	/**
	 * Answer a string naming any items in the specified location
	 * @param currentLocation
	 * @return
	 */
	protected String getItemsDescription(Location currentLocation)
	{
		String items = "";
		
		for (Item item : Application.instance().getItemListForLocation(currentLocation))
		{
			items = items + " You see " + item.name() + " here.";
		} /* end for */
		
		return(items);
	} /* end getItemsDescription */
	
	/**
	 * Answer a string naming any mobs in the specified location
	 * @param currentLocation
	 * @return
	 */
	protected String getMobsDescription(Location currentLocation)
	{
		String mobs = "";
		
		for (MonsterObject mob : Application.instance().getMobListForLocation(currentLocation))
		{
			mobs = mobs + " There is " + mob.name() + " here!";
		} /* end for */
		
		return(mobs);
	} /* end getMobsDescription */
} /* end View */
