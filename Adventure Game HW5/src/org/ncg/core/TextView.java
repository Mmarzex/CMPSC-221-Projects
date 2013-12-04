package org.ncg.core;

/**
 * This view is a simple console view, displaying text directly.
 */
public class TextView extends View
{
	
	
	/**
	 * Observer callback for when the player attempts to go an invalid direction
	 * from their current location
	 * @param direction - The direction the player tried to go
	 */
	public void informInvalidGoDirection(String direction)
	{
		System.out.println("You hit your nose on the wall trying to go " + direction);
	} /* end informInvalidGoDirection */

	/**
	 * Observer callback for when the player has moved (ie changed location)
	 */
	public void informPlayerMoved()
	{
		look();
	} /* end informPlayerMoved */
	
	/**
	 * Tell the player where they are.
	 */
   public void look()
   {
   	Location currentLocation = Application.instance().playerCurrentLocation();
   	System.out.println(currentLocation.description() +
   			             getItemsDescription(currentLocation) +
   			             getMobsDescription(currentLocation) +
   			             getCanMoveDirectionsDescription(currentLocation));
   } /* end look */
} /* end TextView */
