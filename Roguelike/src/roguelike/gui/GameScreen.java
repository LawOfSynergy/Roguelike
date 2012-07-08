package roguelike.gui;

import javax.swing.*;
import java.awt.*;

import roguelike.engine.world.World;

public class GameScreen extends JPanel
{
	private final Dimension bounds = new Dimension(GraphicConstants.SCREEN_WIDTH, GraphicConstants.SCREEN_HEIGHT);
	World world;
	
	public GameScreen(World world)
	{
		this.world = world;
		
		setMinimumSize(bounds);
		setMaximumSize(bounds);
		setPreferredSize(bounds);
		
		setBackground(Color.black);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}
}
