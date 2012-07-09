package roguelike.engine;

import java.awt.Image;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import roguelike.engine.world.MapConstants;
import roguelike.exceptions.AssetInitializationException;
import roguelike.exceptions.UninitializedAssetManagerException;

public class AssetManager <K, V> 
{
	private String fileLoc;
	private Map<K, V> assets;
	private AssetFactory<K, V> factory;
	private String path = "";

	private boolean initialized = false;
	
	public AssetManager(AssetFactory<K, V> factory, String fileLoc)
	{
		this.factory = factory;
		assets = new HashMap<K, V>();
		this.fileLoc = fileLoc;
	}
	
	public V getAsset(K key) throws UninitializedAssetManagerException
	{
		if(!initialized)
			throw new UninitializedAssetManagerException();
		V asset = assets.get(key);
		if(asset == null)asset = factory.getDefaultAsset();
		return asset;
	}
	
	public void initialize() throws IOException, AssetInitializationException
	{
		loadAssets();
		initialized = true;
	}
	
	/**
	 * attempts to match a line to one of the defined commands. If the line matches,
	 * then the command is executed and a value of true is returned immediately 
	 * afterward, otherwise a value of false is returned.
	 * @param line the command to be checked and possibly executed.
	 * @return true if a command and executed, false otherwise.
	 */
	public boolean parseAsCommand(String line){
		//checks
		//# means the line is a comment
		if(line.startsWith("#"))
		{
			return true;
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
			}
		}
		return false;
	}
	
	public void loadAssets() throws IOException, AssetInitializationException
	{
		File file = new File(fileLoc);
		BufferedReader fileStream = new BufferedReader(new FileReader(file));
		String line;
		
		int lineNumber = 0;
		
		while((line = fileStream.readLine()) != null)
		{
			lineNumber++;
			line = line.trim();
			if(!parseAsCommand(line)){
				AssetEntry<K, V> entry = factory.loadAsset(path, lineNumber, line);
				assets.put(entry.getKey(), entry.getValue());
			}
		}
	}
}
