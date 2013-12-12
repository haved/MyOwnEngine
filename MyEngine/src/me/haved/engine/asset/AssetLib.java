package me.haved.engine.asset;

import java.io.File;
import java.util.HashMap;

public class AssetLib
{
	private static HashMap<String, TextureAsset> textures;
	
	public static void unloadAssets()
	{
		if(textures != null)
		{
			for(TextureAsset ta:textures.values())
			{
				ta.unloadAsset();
			}
		}
	}
	
	public static void loadAssets(String loaction)
	{
		textures = new HashMap<String, TextureAsset>();
		
		try
		{
			File f = new File(loaction);
			File[] files = f.listFiles();
			
			for(File file:files)
			{
				loadAsset(file);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void loadAsset(File file)
	{
		String name = file.getName();
		
		if(name.endsWith(".png"))
		{
			loadTextureAsset(file);
		}
	}
	
	private static void loadTextureAsset(File file)
	{
		TextureAsset ta = new TextureAsset();
		ta.loadAsset(file);
		if(ta.isLoaded())
		{
			textures.put(file.getName(), ta);
		}
	}

	public static TextureAsset getTexture(String name)
	{
		return textures.get(name);
	}
}
