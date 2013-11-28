package org.ncg.core;

/**
 * This exception is thrown if an invalid mob id is used.
 */
public class InvalidMobIdException extends Exception
{
	/**
	 * A constructor for the class
	 * @param invalidMobId
	 */
	public InvalidMobIdException(Integer invalidMobId)
	{
		this.invalidMobId = invalidMobId;
	} /* end InvalidMobIdException */

	/**
	 * Access the message describing this exception
	 * @return - The message
	 */
	@Override
	public String getMessage()
	{
		return("An invalid mob id was specified: " + invalidMobId);
	} /* end getMessage */

	/** The invalid mob id used that generated this exception */
   private Integer invalidMobId;
   
	/** The "version" of this object's state, required by Serializable */
	private static final long serialVersionUID = 1L;
} /* end InvalidMobIdException */
