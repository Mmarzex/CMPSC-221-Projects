package org.ncg.core;

public abstract class Entity extends Identifiable {

	/**
	 * An accessor for the Entity's current location.  The location will be
	 * lazy initialized if needed. 
	 * @return - The Entity's current location.
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
	 * Move the Entity to the specified location
	 * @param value - The new location where the Entity will be moved
	 */
	protected void currentLocation(Location value)
	{
		currentLocation = value;
	} /* end currentLocation */
	
   /** The Entity's current location */
   protected Location currentLocation = null;
	
}
