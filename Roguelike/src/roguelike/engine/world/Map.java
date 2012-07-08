package roguelike.engine.world;

import java.awt.Point;
import java.util.ArrayList;

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
		for(int i = 1; i < width-1; i++)
			for(int j = 1; j < height-1; j++)
				map[i][j] = MapConstants.FLOOR_GREY;
		
		for(int i = 1; i < width - 1; i++)
		{
			map[i][0] = MapConstants.BOTTOM_BOUNDARY_WALL;
			map[i][height-1] = MapConstants.TOP_BOUNDARY_WALL;
		}
		
		for(int j = 1; j < height - 1; j++)
		{
			map[0][j] = MapConstants.RIGHT_BOUNDARY_WALL;
			map[width-1][j] = MapConstants.LEFT_BOUNDARY_WALL;
		}
	}
	
	public int get(int x, int y) throws MapIndexOutOfBoundsException
	{
		if(x < 0 || x >= width || y < 0 || y >= height)
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
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}