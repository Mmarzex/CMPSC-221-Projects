package org.ncg.testApp;

import org.ncg.core.ApplicationAlreadyExistsException;
import org.ncg.core.Item;
import org.ncg.core.Location;
import org.ncg.core.MapConnectionAlreadyExists;
import org.ncg.core.MonsterObject;

/**
 * This class is responsible for initializing the application's files.
 */
public class InitializeApplication extends Application
{
	/**
	 * The driver for the program
	 * @param args
	 */
   public static void main(String[] args) throws ApplicationAlreadyExistsException
   {
   	InitializeApplication instance = new InitializeApplication();
   	instance.run();   	
   } /* end main */
	
   /**
    * A constructor for the class
    * @throws ApplicationAlreadyExistsException
    */
   protected InitializeApplication() throws ApplicationAlreadyExistsException
   {
   } /* end InitializeApplication */

   // TODO : Drive this from a text file possibly?
   /**
    * Instantiate the classroom location
    */
   private void createClassroomLocation()
   {
   	classroomLocation = new Location(
   			"This is a classroom. The lighting is terrible. It looks like a grey prison cell.",
   			"a classroom");
   } /* end createClassroomLocation */

   /**
    * Instantiate the hallway location
    */
   private void createHallwayLocation()
   {
   	hallwayLocation = new Location("This is a hallway, long and empty.", "a hallway");
   } /* end createHallwayLocation */

   /**
    * Instantiate the outside Walker Building location
    */
   private void createOutsideWalkerBuildingLocation()
   {
   	outsideWalkerBuildingLocation = new Location(
   			"You are standing outside of Walker Building, a large white structure.",
   			"outside Walker Building");
   } /* end createOutsideWalkerBuildingLocation */

   /**
    * Generate a packet of crackers
    */
   private void createPacketOfCrackersItem()
   {
   	packetOfCrackersItem = new Item("This is an unopened packet of Saltine crackers", "a packet of crackers");
   } /* end createPacketOfCrackersItem */

   /**
    * Generate the squirrel
    */
   private void createSquirrelMob()
   {
   	squirrelMob = new MonsterObject("This appears to be your run-of-the-mill grey squirrel.", "a (seemingly) timid grey squirrel");
   } /* end createSquirrelMob */
   
   /**
    * Generate the items for this game
    */
   private void generateItems()
   {
   	createPacketOfCrackersItem();
   	
   	this.addItem(packetOfCrackersItem);

   	saveItemsToFileNamed("items.dat");   	
   } /* end generateItems */

   /**
    * Generate the locations for this game
    */
   private void generateLocations()
   {
   	createClassroomLocation();
   	createHallwayLocation();
   	createOutsideWalkerBuildingLocation();
   	
   	this.addLocation(classroomLocation);
   	this.addLocation(hallwayLocation);
   	this.addLocation(outsideWalkerBuildingLocation);

   	saveLocationsToFileNamed("locations.dat");   	
   } /* end generateLocations */

   /**
    * Generate the map of locations for this game
    */
   private void generateMap() throws MapConnectionAlreadyExists
   {
   	this.addNorthConnectionToMap(classroomLocation, hallwayLocation);
   	this.addWestConnectionToMap(hallwayLocation, outsideWalkerBuildingLocation);
   	
   	saveMapToFileNamed("map.dat");
   } /* end generateMap */

   /**
    * Generate the mobs
    */
   private void generateMobs()
   {
   	createSquirrelMob();

   	this.addMob(squirrelMob);
   	
   	saveMobsToFileNamed("mobs.dat");
   } /* end generateMobs */
   
   /**
    * The tasks of the application are performed here.
    */
   public void run()
   {
   	try
   	{
   		generateItems();
      	generateLocations();
      	generateMap();
      	generateMobs();
   	}
   	catch(Exception e)
   	{
   		System.out.println("GAH!");
   		System.out.println(e.getLocalizedMessage());
   	} /* end try */
   	
   	System.out.println("Done Initializing");
   } /* end run */

   private Item packetOfCrackersItem;
   
	private Location classroomLocation;
	private Location hallwayLocation;
	private Location outsideWalkerBuildingLocation;
	
	private MonsterObject squirrelMob;
} /* end InitializeApplication */
