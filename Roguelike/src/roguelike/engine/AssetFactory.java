package roguelike.engine;

import java.util.Map;

import roguelike.exceptions.AssetInitializationException;

public interface AssetFactory<K,V>{;
	public AssetEntry<K, V> loadAsset(String path, int lineNumber, String line)throws AssetInitializationException;
	public V getDefaultAsset();
	public void setDefaultAsset(V asset);
}
