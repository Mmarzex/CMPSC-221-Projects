package org.ncg.core;

/**
 * An abstract base class for entities in the game
 */
public abstract class Entity extends Identifiable
{
	/**
	 * An accessor for the player's current location.  The location will be
	 * lazy initialized if needed. 
	 * @return - The player's current location.
	 */
	protected Location currentLocation()
	{
		// We use direct member access here so we don't get the side-effect of
		// informing observers of the location change (since we're initializing
		// it).
		if (null == currentLocation) currentLocation = Application.instance().initialLocation();
		return(currentLocation);
	} /* end currentLocation */

	/**
	 * Move the player to the specified location
	 * @param value - The new location where the player will be moved
	 */
	protected void currentLocation(Location value)
	{
		currentLocation = value;
	} /* end currentLocation */	

   /** The player's current location */
   private Location currentLocation = null;

	/** The "version" of this object's state, required by Serializable */
	private static final long serialVersionUID = 1L;
} /* end Entity */
