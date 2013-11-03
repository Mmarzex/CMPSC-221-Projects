package org.ncg.core;

public class Item extends Identifiable {

	/**
	 * Default Item Constructor
	 */
	public Item() {
		super();
		this.name = "";
		this.description = "";
	}
	
	/**
	 * Item constructor where user provides name and description
	 * @param name - 
	 * @param description
	 */
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Returns Item Description
	 * @return The Item's description
	 */
	public String description() {
		return this.description;
	}
	
	/**
	 * Returns Item Name
	 * @return The Item's name
	 */
	public String name() {
		return this.name;
	}
	
	/**
	 * Description of an Item
	 */
	private String description;
	
	/**
	 * Name of an Item
	 */
	private String name;
	
	/**
	 * The "version" of this object's state, required by Serializable 
	 */
	private static final long serialVersionUID = 1L;

}
