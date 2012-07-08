package roguelike.engine.entity;

import java.awt.Point;

public class Entity 
{
	//used for identifying the entity in the game
	private final int id;
	Point position;

	public Entity(int id, Point position)
	{
		this.id = id;
		this.position = position;
	}
}
