package org.ncg.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is the root of the abilities of an Application.  Support for all
 * uses of this "application" framework are supported here.
 */
public abstract class Application
{
   /**
    * A constructor for the class.
    * 
	 * @throws ApplicationAlreadyExistsException - This constructor may only be
	 * called once.  This exception is thrown for any calls after the first
	 * call 
    */
   protected Application() throws ApplicationAlreadyExistsException
   {
   	if (null == instance)
   	{
   	   instance = this;
   	}
   	else
   	{
   		throw new ApplicationAlreadyExistsException();
   	} /* end if */
   } /* end Application */

	/**
	 * Add the specified connection to the map.  Also add its dual.  If the
	 * connection already exists, do nothing.
	 * @param from
	 * @param to
	 * @throws MapConnectionAlreadyExists - If a different connection already
	 * exists to the east for "from" (or to the west from "to"), throw this
	 * exception.
	 */
	protected void addEastConnectionToMap(Location from, Location to) throws MapConnectionAlreadyExists
	{
		map().addEastConnection(from, to);
		map().addWestConnection(to, from);
	} /* end addEastConnectionToMap */
	
	/**
	 * Add the specified item to the hash map
	 * @param item - The item to add
	 */
	protected void addItem(Item item)
	{
		items.add(item);
	} /* end addItem */

	/**
	 * Add the specified location to the hash map
	 * @param location - The location to add
	 */
	protected void addLocation(Location location)
	{
		locations.add(location);
	} /* end addLocation */

	/**
	 * Add the specified mob to the hash map
	 * @param mob - The mob to add
	 */
	protected void addMob(MonsterObject mob)
	{
		mobs.add(mob);
	} /* end addMob */

	/**
	 * Add the specified connection to the map.  Also add its dual.  If the
	 * connection already exists, do nothing.
	 * @param from
	 * @param to
	 * @throws MapConnectionAlreadyExists - If a different connection already
	 * exists to the north for "from" (or to the south from "to"), throw this
	 * exception.
	 */
	protected void addNorthConnectionToMap(Location from, Location to) throws MapConnectionAlreadyExists
	{
		map().addNorthConnection(from, to);
		map().addSouthConnection(to, from);
	} /* end addNorthConnectionToMap */
	
	/**
	 * Add the specified connection to the map.  Also add its dual.  If the
	 * connection already exists, do nothing.
	 * @param from
	 * @param to
	 * @throws MapConnectionAlreadyExists - If a different connection already
	 * exists to the south for "from" (or to the north from "to"), throw this
	 * exception.
	 */
	protected void addSouthConnectionToMap(Location from, Location to) throws MapConnectionAlreadyExists
	{
		map().addSouthConnection(from, to);
		map().addNorthConnection(to, from);
	} /* end addSouthConnectionToMap */
	
	/**
	 * Add the specified connection to the map.  Also add its dual.  If the
	 * connection already exists, do nothing.
	 * @param from
	 * @param to
	 * @throws MapConnectionAlreadyExists - If a different connection already
	 * exists to the west for "from" (or to the east from "to"), throw this
	 * exception.
	 */
	protected void addWestConnectionToMap(Location from, Location to) throws MapConnectionAlreadyExists
	{
		map().addWestConnection(from, to);
		map().addEastConnection(to, from);
	} /* end addWestConnectionToMap */

	/**
	 * Determine the location to the east of the specified location
	 * @param location
	 * @return - The location to the east of the specified location
	 */
	protected Location determineLocationEastOf(Location location) throws NoLocationInDirectionException
	{
		return(map.determineLocationEastOf(location));
	} /* end determineLocationEastOf */
	
	/**
	 * Determine the location to the north of the specified location
	 * @param location
	 * @return - The location to the north of the specified location
	 */
	protected Location determineLocationNorthOf(Location location) throws NoLocationInDirectionException
	{
		return(map.determineLocationNorthOf(location));
	} /* end determineLocationNorthOf */
	
	/**
	 * Determine the location to the south of the specified location
	 * @param location
	 * @return - The location to the south of the specified location
	 */
	protected Location determineLocationSouthOf(Location location) throws NoLocationInDirectionException
	{
		return(map.determineLocationSouthOf(location));
	} /* end determineLocationSouthOf */
	
	/**
	 * Determine the location to the west of the specified location
	 * @param location
	 * @return - The location to the west of the specified location
	 */
	protected Location determineLocationWestOf(Location location) throws NoLocationInDirectionException
	{
		return(map.determineLocationWestOf(location));
	} /* end determineLocationWestOf */

	/**
	 * Answer the item list for the specified location.
	 * @param location
	 * @return
	 */
	protected List<Item> getItemListForLocation(Location location)
	{
		Integer key = location.id();
		List<Item> list = locationItems.get(key);
		
		// Lazy initialize it, if needed
		if (null == list)
		{
			list = new ArrayList<Item>();
			locationItems.put(key, list);
		} /* end if */
		
		return(list);
	} /* end getItemListForLocation */
	
	/**
	 * Answer the item with the specified id
	 * @param id
	 * @return
	 * @throws InvalidItemIdException
	 */
	protected Item getItemWithId(Integer id) throws InvalidItemIdException
	{
		Item item = items.get(id);
		if (null == item) throw new InvalidItemIdException(id);
		return(item);
	} /* end getItemWithId */
	
	/**
	 * Answer the location with the specified id
	 * @param id
	 * @return
	 * @throws InvalidLocationIdException
	 */
	protected Location getLocationWithId(Integer id) throws InvalidLocationIdException
	{
		Location location = locations.get(id);
		if (null == location) throw new InvalidLocationIdException(id);
		return(location);
	} /* end getLocationWithId */
	
	/**
	 * Answer the mob list for the specified location.
	 * @param location
	 * @return
	 */
	protected List<MonsterObject> getMobListForLocation(Location location)
	{
		List<MonsterObject> list = locationMobs.get(location);
		
		// Lazy initialize it, if needed
		if (null == list)
		{
			list = new ArrayList<MonsterObject>();
			locationMobs.put(location, list);
		} /* end if */
		
		return(list);
	} /* end getMobListForLocation */
	
	/**
	 * Answer the mob with the specified id
	 * @param id
	 * @return
	 * @throws InvalidMobIdException
	 */
	protected MonsterObject getMobWithId(Integer id) throws InvalidMobIdException
	{
		MonsterObject mob = mobs.get(id);
		if (null == mob) throw new InvalidMobIdException(id);
		return(mob);
	} /* end getMobWithId */
	
	/**
	 * Modify the id of the initial location for the game.  The specified value
	 * must be a valid location id of an existing location.  The default value is
	 * specified in the member's definition.
	 * @param value - The new value for the id of the initial location.
	 * @throws InvalidLocationIdException
	 */
	protected void idForInitialLocation(Integer value) throws InvalidLocationIdException
	{
		if (!locations.containsKey(value)) throw new InvalidLocationIdException(value);
		idForInitialLocation = value;
	} /* end idForInitialLocation */

	/**
	 * Inform observers that the player attempted to go an invalid direction
	 * @param direction - The invalid direction the player tried to go
	 */
	protected void informInvalidGoDirectionObservers(String direction)
	{
		view.informInvalidGoDirection(direction);
	} /* end informInvalidGoDirectionObservers */
	
	/**
	 * Inform observers that the player has moved.
	 */
	protected void informPlayerMovedObservers()
	{
		view.informPlayerMoved();
	} /* end informPlayerMovedObservers */
	
	/**
	 * Access the initial location for this game.
	 * @return - The initial location
	 */
	protected Location initialLocation()
	{
		try
		{
		   return(getLocationWithId(idForInitialLocation));
		}
		catch (InvalidLocationIdException e)
		{
			return(new Location("INVALID ID FOR INITIAL LOCATION", "INVALID LOCATION"));
		} /* end try */
	} /* end initialLocation */
	
   /**
    * The Singleton accessor for the class
    * @return
    */
   public static Application instance()
   {
   	return(instance);
   } /* end instance */

	/**
	 * Answer whether there is a location to the east of the specified location
	 * @param location
	 * @return
	 */
	protected boolean isThereALocationEastOf(Location location)
	{
		boolean doesLocationExist = true;
		
		try
		{
			determineLocationEastOf(location);
		}
		catch (NoLocationInDirectionException e)
		{
			doesLocationExist = false;
		} /* end catch */
		
		return(doesLocationExist);
	} /* end isThereALocationEastOf */
	
	/**
	 * Answer whether there is a location to the north of the specified location
	 * @param location
	 * @return
	 */
	protected boolean isThereALocationNorthOf(Location location)
	{
		boolean doesLocationExist = true;
		
		try
		{
			determineLocationNorthOf(location);
		}
		catch (NoLocationInDirectionException e)
		{
			doesLocationExist = false;
		} /* end catch */
		
		return(doesLocationExist);
	} /* end isThereALocationNorthOf */
	
	/**
	 * Answer whether there is a location to the south of the specified location
	 * @param location
	 * @return
	 */
	protected boolean isThereALocationSouthOf(Location location)
	{
		boolean doesLocationExist = true;
		
		try
		{
			determineLocationSouthOf(location);
		}
		catch (NoLocationInDirectionException e)
		{
			doesLocationExist = false;
		} /* end catch */
		
		return(doesLocationExist);
	} /* end isThereALocationSouthOf */
	
	/**
	 * Answer whether there is a location to the west of the specified location
	 * @param location
	 * @return
	 */
	protected boolean isThereALocationWestOf(Location location)
	{
		boolean doesLocationExist = true;
		
		try
		{
			determineLocationWestOf(location);
		}
		catch (NoLocationInDirectionException e)
		{
			doesLocationExist = false;
		} /* end catch */
		
		return(doesLocationExist);
	} /* end isThereALocationWestOf */
	
   /**
    * Load the items database from a file with the specified file name
    * @param fileName - The name of the file from which the items are to be
    * deserialized.
    */
	protected void loadItemsFromFileNamed(String fileName)
	{
		items = (AdventureGameHashMap<Item>)loadObjectFromFileNamed(fileName);
	} /* end loadItemsFromFileNamed */

   /**
    * Load the locations database from a file with the specified file name
    * @param fileName - The name of the file from which the locations are to be
    * deserialized.
    */
	protected void loadLocationsFromFileNamed(String fileName)
	{
		locations = (AdventureGameHashMap<Location>)loadObjectFromFileNamed(fileName);
	} /* end loadLocationsFromFileNamed */

   /**
    * Load the map from a file with the specified file name
    * @param fileName - The name of the file from which the map is to be
    * deserialized.
    */
   protected void loadMapFromFileNamed(String fileName)
	{
		map = (Map)loadObjectFromFileNamed(fileName);
	} /* end loadMapFromFileNamed */

   /**
    * Load the mobs from a file with the specified file name
    * @param fileName - The name of the file from which the mobs are to be
    * deserialized.
    */
   protected void loadMobsFromFileNamed(String fileName)
	{
		mobs = (AdventureGameHashMap<MonsterObject>)loadObjectFromFileNamed(fileName);
	} /* end loadMobsFromFileNamed */

	/**
	 * Load the single object from the file with the specified file name.
	 * @param fileName - The name of the file from which to read an Object
	 * @return - The Object read 
	 */
	protected Object loadObjectFromFileNamed(String fileName)
	{
		Object objectLoaded = null;
		
   	try ( // AutoCloseable objects go here!  finally not needed to close!
   			java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileName);
   			java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(fileInputStream);
   			java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(bufferedInputStream);
   	    )
   	{
   		objectLoaded = objectInputStream.readObject();
	   }
   	catch(java.lang.ClassNotFoundException e)
	   {
		   System.out.println(e.getLocalizedMessage());
	   }
   	catch(java.io.IOException e)
	   {
		   System.out.println(e.getLocalizedMessage());
   	} /* end try */
   	
   	return(objectLoaded);
	} /* end loadLocationsFromFileNamed */

	/**
	 * Tell the user where we are
	 */
	protected void look()
	{
		view.look();
	} /* end look */
	
	/**
	 * Provide lazy initialization access to the map
	 * @return - A valid map object
	 */
	protected Map map()
	{
		if (null == map) map(new org.ncg.core.Map());
		return(map);
	} /* end map */
	
	/**
	 * Replace the existing map with the specified one.
	 * @param map - The new map to use.
	 */
	protected void map(Map map)
	{
      this.map = map;
	} /* end map */

	/**
	 * Move the player east from their current location
	 */
	protected void movePlayerEast()
	{
		player.goEast();
	} /* end movePlayerEast */
	/**
	 * Move the player north from their current location
	 */
	protected void movePlayerNorth()
	{
		player.goNorth();
	} /* end movePlayerNorth */
	
	/**
	 * Move the player south from their current location
	 */
	protected void movePlayerSouth()
	{
		player.goSouth();
	} /* end movePlayerSouth */
	
	/**
	 * Move the player west from their current location
	 */
	protected void movePlayerWest()
	{
		player.goWest();
	} /* end movePlayerWest */

	/**
	 * Put the specified item in the given location
	 * @param item
	 * @param location
	 */
	protected void placeItemInLocation(Item item, Location location)
	{
		List<Item> list = getItemListForLocation(location);
		list.add(item);
	} /* end placeItemInLocation */
	
	/**
	 * Place the specified mob at the given location
	 * @param mob
	 * @param location
	 */
	protected void placeMobAtLocation(MonsterObject mob, Location location)
	{
		List<MonsterObject> list = getMobListForLocation(location);
		list.add(mob);
	} /* end placeMobAtLocation */
	
	/**
	 * An accessor for the player's current location.  The location will be
	 * lazy initialized if needed. 
	 * @return - The player's current location.
	 */
	protected Location playerCurrentLocation()
	{
		return(player.currentLocation());
	} /* end playerCurrentLocation */
	
   /**
    * This is the starting point of the application.  Since each individual
    * game that uses this framework is distinct, each is responsible for
    * providing an implementation of this method
    */
   public abstract void run();

   /**
    * Save the current items database to a file with the specified file
    * name
    * @param fileName - The name of the file where the items are to be
    * serialized.
    */
	protected void saveItemsToFileNamed(String fileName)
	{
		saveObjectToFileNamed(items, fileName);
	} /* end saveItemsToFileNamed */

   /**
    * Save the current locations database to a file with the specified file
    * name
    * @param fileName - The name of the file where the locations are to be
    * serialized.
    */
	protected void saveLocationsToFileNamed(String fileName)
	{
		saveObjectToFileNamed(locations, fileName);
	} /* end saveLocationsToFileNamed */

   /**
    * Save the map to a file with the specified file name
    * @param fileName - The name of the file where the map is to be serialized.
    */
	protected void saveMapToFileNamed(String fileName)
	{
		saveObjectToFileNamed(map, fileName);
	} /* end saveMapToFileNamed */

   /**
    * Save the mobs to a file with the specified file name
    * @param fileName - The name of the file where the mobs are to be serialized.
    */
	protected void saveMobsToFileNamed(String fileName)
	{
		saveObjectToFileNamed(mobs, fileName);
	} /* end saveMobsToFileNamed */

	/**
	 * Save the specified objectToSave to a file with the specified file name
	 * @param objectToSave - The object to save (duh!)
	 * @param fileName - The name of the file where the object is to be saved
	 */
	protected void saveObjectToFileNamed(Object objectToSave, String fileName)
	{
   	try ( // AutoCloseable objects go here!  finally not needed to close!
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(fileName);
            java.io.BufferedOutputStream bufferedOutputStream = new java.io.BufferedOutputStream(fileOutputStream);
            java.io.ObjectOutputStream objectOutputStream = new java.io.ObjectOutputStream(bufferedOutputStream);
   	    )
   	{
         objectOutputStream.writeObject(objectToSave);
	   }
   	catch(java.io.IOException e)
	   {
		   System.out.println(e.getLocalizedMessage());
   	} /* end try */		
	} /* end saveObjectToFileNamed */

	/** The id of the initial location */
	private Integer idForInitialLocation = 0;
	
   /** The Singleton instance */
   private static Application instance = null;

   /** The list of all items */
   private static AdventureGameHashMap<Item> items = new AdventureGameHashMap<>(); 

   /** The mapping of location to the items that are placed there */ 
   private HashMap<Integer, List<Item>> locationItems = new HashMap<>();
   
   /** The mapping of location to the mobs that are there */ 
   private HashMap<Location, List<MonsterObject>> locationMobs = new HashMap<>();
   
   /** The list of all locations */
   private static AdventureGameHashMap<Location> locations = new AdventureGameHashMap<>(); 

   /** The map of locations */
   private Map map = null;
   
   /** The list of all mobs */
   private static AdventureGameHashMap<MonsterObject> mobs = new AdventureGameHashMap<>(); 

   /** The player */
   private Player player = new Player();
   
   /** The view */
   private View view = new GuiView();
} /* end Application */
