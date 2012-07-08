package roguelike.gui;

import javax.swing.*;

import roguelike.engine.GameConstants;
import roguelike.engine.world.World;

import java.awt.*;

public class GameFrame extends JFrame
{		
	public GameFrame(World world)
	{
		JPanel screen = new GameScreen(world);
		this.getContentPane().add(screen, BorderLayout.CENTER);
	
		this.setResizable(false);
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle(GameConstants.GAME_TITLE);
				
		this.pack();
		//center frame
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}