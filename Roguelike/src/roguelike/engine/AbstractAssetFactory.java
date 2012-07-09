package roguelike.engine;

import java.util.Map;

public abstract class AbstractAssetFactory<K, V> implements AssetFactory<K, V>{
	private V defaultAsset;
	
	public V getDefaultAsset()
	{
		return defaultAsset;
	}
	
	public void setDefaultAsset(V asset)
	{
		defaultAsset = asset;
	}
}
