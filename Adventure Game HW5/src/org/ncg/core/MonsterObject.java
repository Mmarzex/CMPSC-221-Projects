package org.ncg.core;

/**
 * A MOB
 */
public class MonsterObject extends Entity
{
	/**
	 * A constructor for the class.  This constructor is used to manually or
	 * programmatically create new locations.
	 * @param description - The location's description
	 * @param name - The location's "short" name
	 */
	public MonsterObject(String description, String name)
	{
		super();
		this.description = description;
		this.name = name;
	} /* end MonsterObject */

	/**
	 * Access the description
	 * @return - The location's description
	 */
	public String description()
	{
		return(description);
	} /* end description */
		
	/**
	 * Access the name
	 * @return - The Location's name
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
} /* end MonsterObject */
