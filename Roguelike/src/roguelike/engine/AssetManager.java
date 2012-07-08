package roguelike.engine;

import java.awt.Image;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class AssetManager 
{
	static String tileFileLocation = "assets/graphics/tile.txt";
	static Map<Integer, Image> imageMap;
	
	private AssetManager()
	{
		
	}
	
	static
	{
		try 
		{
			initialize();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Image getImage(int id)
	{
		return imageMap.get(id);
	}
	
	public static void initialize() throws IOException
	{
		loadGraphicalAssets();
	}
	
	public static void loadGraphicalAssets() throws IOException
	{
		File mapFile = new File(tileFileLocation);
		BufferedReader fileStream = new BufferedReader(new FileReader(mapFile));
		String line;
		imageMap = new HashMap<Integer, Image>();
		
		while((line = fileStream.readLine()) != null)
		{
			//# means the line is a comment
			if(line.startsWith("#"))
			{
				continue;
			}
			
			else
			{
				//Line isn't empty
				if(!line.equals(""))
				{
					String[] map = line.split(" ");
					
					int tileID = Integer.parseInt(map[0]);
					
					File file = new File(map[1]);
					if(!file.exists())
					{
						throw new FileNotFoundException();
					}
					
					imageMap.put(Integer.parseInt(map[0]),
							ImageIO.read(file));
				}
			}
		}
	}
}
