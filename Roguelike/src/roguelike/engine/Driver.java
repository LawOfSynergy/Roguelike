package roguelike.engine;

import java.io.IOException;

import roguelike.gui.GameFrame;
import roguelike.engine.world.World;

public class Driver
{
	public static void main(String[] args) throws IOException
	{
//		AssetManager.initialize();
		GameFrame frame = new GameFrame(new World());
	}
}
