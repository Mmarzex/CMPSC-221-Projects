package org.ncg.core;

public class MonsterObject extends Entity {

	public MonsterObject() {
		super();
		name = "";
		description = "";
	}
	
	public MonsterObject(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	private String name;
	private String description;
}
