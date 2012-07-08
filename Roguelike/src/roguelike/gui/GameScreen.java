package roguelike.gui;

import javax.swing.*;
import java.awt.*;

import roguelike.engine.world.Map;
import roguelike.engine.world.World;
import roguelike.engine.AssetManager;
import roguelike.exceptions.MapIndexOutOfBoundsException;
import roguelike.exceptions.UnitializedGraphicsException;

public class GameScreen extends JPanel 
{
	private final Dimension bounds = new Dimension(
			GraphicConstants.SCREEN_WIDTH, GraphicConstants.SCREEN_HEIGHT);
	World world;
	Dimension tileSize;

	public GameScreen(World world) {
		this.world = world;

		setMinimumSize(bounds);
		setMaximumSize(bounds);
		setPreferredSize(bounds);

		int tileWidth = (int) ((bounds.getWidth() - 2 * GraphicConstants.SCREEN_BORDER) / world
				.getMap().getWidth());
		int tileHeight = (int) ((bounds.getHeight() - 2 * GraphicConstants.SCREEN_BORDER) / world
				.getMap().getHeight());

		tileSize = new Dimension(tileWidth, tileHeight);

		setBackground(Color.black);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		try {

			Map map = world.getMap();
			for (int i = 0; i < map.getWidth(); i++) {
				for (int j = 0; j < map.getHeight(); j++) {
					
					int x = (int) (20 + (i * tileSize.getWidth()));
					int y = (int) (20 + (j * tileSize.getHeight()));

					int tileID = map.get(i, j);

					System.out.printf("%5d ", tileID);
					g.drawImage(AssetManager.getImageForTile(tileID), x, y,
							(int) tileSize.getWidth(),
							(int) tileSize.getHeight(), null);

				}

				System.out.println("\n\n");
			}
		}

		catch (UnitializedGraphicsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MapIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
