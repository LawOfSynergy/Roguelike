package roguelike.engine.world;

public class MapConstants 
{
	public static final int DEFAULT_MAP_WIDTH = 20;
	public static final int DEFAULT_MAP_HEIGHT = 20;
	
	/**
	 * Tile IDs
	 * These are used to represent the different types 
	 * of tiles in the map. The art assets are linked in the 
	 * tile.txt file in assets/graphics.
	 */
		
	//Null tile
	public static final int NULL_TILE = -1;
	
	//Walls
	private static final int DEFAULT_WALL = 100;
		public static final int HORIZONTAL_WALL = DEFAULT_WALL + 1;
		public static final int VERTICAL_WALL = DEFAULT_WALL + 2;

	private static final int BOUNDARY_WALL = DEFAULT_WALL + 100;
		public static final int LEFT_BOUNDARY_WALL = BOUNDARY_WALL + 1;
		public static final int RIGHT_BOUNDARY_WALL = BOUNDARY_WALL + 2;
		public static final int TOP_BOUNDARY_WALL = BOUNDARY_WALL + 3;
		public static final int BOTTOM_BOUNDARY_WALL = BOUNDARY_WALL + 4;
			
 
	//Floors
	private static final int DEFAULT_FLOOR = 0;
		public static final int FLOOR_GREY = DEFAULT_FLOOR + 1;
}
