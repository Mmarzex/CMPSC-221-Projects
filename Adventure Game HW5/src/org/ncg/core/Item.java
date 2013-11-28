package org.ncg.core;

/**
 * This class represents an item that entities can get, drop, or use in various
 * manners in the adventure game.
 */
public class Item extends Identifiable
{
	/**
	 * A constructor for the class.  This constructor is used to manually or
	 * programmatically create new locations.
	 * @param description - The location's description
	 * @param name - The location's "short" name
	 */
	public Item(String description, String name)
	{
		super(); // The id is assigned when this object is added to its list.
		this.description = description;
		this.name = name;
	} /* end Item */

	/**
	 * Access the description
	 * @return - The item's description
	 */
	public String description()
	{
		return(description);
	} /* end description */
		
	/**
	 * Access the name
	 * @return - The Item's name
	 */
	public String name()
	{
		return(name);
	} /* end name */
	
	/** The description */
	private String description;

	/** The name */
	private String name;
	
	/** The "version" of this object's state, required by Serializable */
	private static final long serialVersionUID = 1L;
} /* end Item */
