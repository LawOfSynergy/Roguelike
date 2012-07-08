package roguelike.engine;

import java.awt.Image;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import roguelike.exceptions.UnitializedGraphicsException;

public class AssetManager 
{
	static String tileFileLocation = "assets/graphics/tile.txt";
	static Map<Integer, Image> tileMap;

	static boolean initialized = false;
	
	private AssetManager()
	{
		
	}

	/*
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
	*/
	
	public static Image getImageForTile(int id) throws UnitializedGraphicsException
	{
		if(!initialized)
			throw new UnitializedGraphicsException();
		return tileMap.get(id);
	}
	
	public static void initialize() throws IOException
	{
		loadGraphicalAssets();
		
		initialized = true;
	}
	
	public static void loadGraphicalAssets() throws IOException
	{
		
		//tiles
		File mapFile = new File(tileFileLocation);
		BufferedReader fileStream = new BufferedReader(new FileReader(mapFile));
		String line;
		tileMap = new HashMap<Integer, Image>();
		String path = "";
		
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
					if(line.startsWith("setpath"))
					{
						String newPath = line.split(" ")[1];
						
						// ./filepath - maintains current path
						if(newPath.startsWith("./"))
						{
							path += newPath.substring(newPath.indexOf(".")+1);
						}
						
						// ../filepath - moves up one directory
						else if(newPath.startsWith("../"))
						{
							path = path.substring(0, path.lastIndexOf('/'));
							path = path.substring(0, path.lastIndexOf('/'));
							path += newPath.substring(newPath.indexOf("/")+1);
						}
						
						else
						{
							path = newPath;
						}
					}
					
					else
					{
						String[] map = line.split(" ");
						
						int tileID = Integer.parseInt(map[0]);
						
						File file = new File(path+map[1]);
						
						if(!file.exists())
						{
							throw new FileNotFoundException();
						}
						
						tileMap.put(Integer.parseInt(map[0]),
								ImageIO.read(file));
					}
				}
			}
		}
	}
}
