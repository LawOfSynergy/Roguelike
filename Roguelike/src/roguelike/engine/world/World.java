package roguelike.engine.world;

import java.awt.Point;
import java.util.*;

import roguelike.engine.entity.Entity;
import roguelike.engine.entity.PlayerCharacter;

/**
 * World exists as a manager of the map and entities. 
 * It manages entities and ensures that they do not exhibit 
 * impossible behaviors such as leaving the map or having negative
 * health.
 */
public class World 
{
	private Map map;
	private Entity player;
	private List<Entity> otherEntities;
	
	int currentId;
	
	public World()
	{
		map = new Map();
		player = new PlayerCharacter(0, new Point(0, 0));
		otherEntities = new ArrayList<Entity>();
	}
}
