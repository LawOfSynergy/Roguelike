package roguelike.engine.world;

public class MapConstants 
{
	public static final int DEFAULT_MAP_WIDTH = 300;
	public static final int DEFAULT_MAP_HEIGHT = 300;
	
	/**
	 * Tile IDs
	 * These are used to represent the different types 
	 * of tiles in the map. The art assets are linked in the 
	 * graphicmap.txt file in assets/graphics.
	 */
	
	//Different Wall Orientations
	private static final int WALL = 100;
		public static final int LEFT_WALL = WALL + 1;
		public static final int RIGHT_WALL = WALL + 2;
		public static final int TOP_WALL = WALL + 3;
		public static final int BOTTOM_WALL = WALL + 4;
		
	private static final int FLOOR = 0;
		public static final int FLOOR_GREY = FLOOR + 1;
}
