package me.haved.engine.world;

import java.io.File;
import java.util.HashMap;

import me.haved.engine.core.GameType;

public final class WorldUniverse
{
	private static HashMap<String, World> worlds;
	
	public static void loadWorlds(File worldLocation, GameType gameType)
	{
		try
		{	
			worlds = new HashMap<String, World>();
			
			File[] files = worldLocation.listFiles();
			
			World w;
			String name;
			for(File file:files)
			{
				name = file.getName();
				if(name.endsWith(".map") == false) continue;
				
				w = WorldReader.getWorldFromFile(file, gameType);
				if(w != null)
				{
					worlds.put(name.substring(0, name.length() - 4), w);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static World getWorld(String name)
	{
		return worlds.get(name);
	}
}
