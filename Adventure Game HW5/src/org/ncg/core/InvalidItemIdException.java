package org.ncg.core;

/**
 * This exception is thrown if an invalid item id is used.
 */
public class InvalidItemIdException extends Exception
{
	/**
	 * A constructor for the class
	 * @param invalidItemId
	 */
	public InvalidItemIdException(Integer invalidItemId)
	{
		this.invalidItemId = invalidItemId;
	} /* end InvalidItemIdException */

	/**
	 * Access the message describing this exception
	 * @return - The message
	 */
	@Override
	public String getMessage()
	{
		return("An invalid item id was specified: " + invalidItemId);
	} /* end getMessage */

	/** The invalid item id used that generated this exception */
   private Integer invalidItemId;
   
	/** The "version" of this object's state, required by Serializable */
	private static final long serialVersionUID = 1L;
} /* end InvalidItemIdException */
