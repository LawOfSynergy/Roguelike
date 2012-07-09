package roguelike.engine;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import roguelike.exceptions.AssetInitializationException;

public class TileFactory extends AbstractAssetFactory<Integer, Image>{
	public AssetEntry<Integer, Image> loadAsset(String path, int lineNumber, String line)throws AssetInitializationException
	{
		String[] map = line.split(" ");
		int tileID = Integer.parseInt(map[0]);
		File file = new File(path+map[1]);
		
		if(!file.exists())
		{
			throw new AssetInitializationException(new FileNotFoundException("File " + file.getPath() + " specified in line " + lineNumber + " cannot be found!"));
		}
		try {
			return new AssetEntry<Integer, Image>(tileID, ImageIO.read(file));
		} catch (NumberFormatException ex) {
			throw new AssetInitializationException(ex);
		} catch (IOException ex) {
			throw new AssetInitializationException(ex);
		}
	}
}
