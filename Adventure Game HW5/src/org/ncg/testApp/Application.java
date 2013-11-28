package org.ncg.testApp;

import org.ncg.core.*;

/**
 * This is the test application for an adventure game.  It is a Singleton.
 */
public class Application extends org.ncg.core.Application
{
	/**
	 * The driver for the program
	 * @param args
	 */
   public static void main(String[] args) throws ApplicationAlreadyExistsException
   {
   	Application instance = new Application();
   	instance.run();   	
   } /* end main */

   /**
    * A constructor for the class
    * @throws ApplicationAlreadyExistsException
    */
   protected Application() throws ApplicationAlreadyExistsException
   {
   } /* end Application */
   
   // TODO : Delete me
   private void emplaceItems()
   {
   	try
   	{
      	Item crackers = getItemWithId(0);
      	Location classRoom = getLocationWithId(0);
   	   placeItemInLocation(crackers, classRoom);
   	}
   	catch (Exception e)
   	{
   		System.out.println(e.getLocalizedMessage());
   	} /* end try */
   } /* end emplaceItems */

   // TODO : Delete me
   private void emplaceMobs()
   {
   	try
   	{
      	MonsterObject squirrel = getMobWithId(0);
      	Location outsideWalkerBuilding = getLocationWithId(2);
   	   placeMobAtLocation(squirrel, outsideWalkerBuilding);
   	}
   	catch (Exception e)
   	{
   		System.out.println(e.getLocalizedMessage());
   	} /* end try */   	
   } /* end emplaceMobs */
   
   // TODO : Delete me
   private void loadItems()
   {
   	loadItemsFromFileNamed("items.dat");   	
   } /* end loadItems */

   // TODO : Delete me
   private void loadLocations()
   {
   	loadLocationsFromFileNamed("locations.dat");   	
   } /* end loadLocations */

   // TODO : Delete me
   private void loadMap()
   {
   	loadMapFromFileNamed("map.dat");   	
   } /* end loadMap */
   
   // TODO : Delete me
   private void loadMobs()
   {
   	loadMobsFromFileNamed("mobs.dat");   	
   } /* end loadMobs */
   
   /**
    * The tasks of the application are performed here.
    */
   public void run()
   {
   	loadItems();
   	loadLocations();
   	loadMap();
   	loadMobs();
   	emplaceItems();
   	emplaceMobs();
   	
   	System.out.print("look: ");
   	look();
   	
//   	System.out.print("go east: ");
//   	movePlayerEast();
//
//   	System.out.print("go north: ");
//   	movePlayerNorth();
//
//   	System.out.print("go south: ");
//   	movePlayerSouth();
//
//   	System.out.print("go west: ");
//   	movePlayerWest();
//
//   	System.out.print("go north: ");
//   	movePlayerNorth();
//
//   	System.out.print("go west: ");
//   	movePlayerWest();

   	System.out.println("Done");
   } /* end run */
} /* end Application */
