package roguelike.engine.world;

import roguelike.exceptions.MapIndexOutOfBoundsException;

/**
 * Contains the representation of the map and internal boundaries 
 * (e.g. walls). However, it does not handle the locations of entities,
 * this is handled by World. 
 */

public class Map 
{
	private int width;
	private int height;
	
	private int[][] map;
	
	public Map()
	{
		this(MapConstants.DEFAULT_MAP_WIDTH, MapConstants.DEFAULT_MAP_HEIGHT);
	}
	
	public Map(int width, int height)
	{
		this.width = width;
		this.height = height;
		
		//TODO: Generate map or load from file.
		map = new int[width][height];
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++)
				map[i][j] = MapConstants.FLOOR_GREY;
	}
	
	public int get(int x, int y) throws MapIndexOutOfBoundsException
	{
		if(x < 0 || x > width || y < 0 || y > height)
		{
			String errorMessage = "Attempt to access outside " +
					"of the bounds of the Map.";
			errorMessage += "\nMap Bounds: " + width + ", " + height;
			errorMessage += "\nAccess Location: " + x + "," + y;
			throw new MapIndexOutOfBoundsException(errorMessage);
		}
		
		else
		{
			return map[x][y];
		}
	}
}
