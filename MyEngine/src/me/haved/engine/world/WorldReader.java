package me.haved.engine.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;

public final class WorldReader
{
	public static World getWorldFromFile(File file, GameType gameType)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			World world = new World(gameType);
			
			String s;
			while((s = reader.readLine()) != null)
			{
				if(s.startsWith("#")) continue;
				if(s.startsWith("E-"))
				{
					world.addEntity(getEntityFromString(s.substring(2, s.length()), gameType));
				}
				
				if(s.startsWith("SIZE-"))
				{
					String[] vals = s.substring(5).split(",");
					world.setWidth(Integer.parseInt(vals[0]));
					world.setHeight(Integer.parseInt(vals[1]));
				}
			}
			
			reader.close();
			
			return world;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static Entity getEntityFromString(String s, GameType gameType)
	{
		try
		{
			String[] parts = s.split(",");
			Class<? extends Entity> clazz = gameType.getEntity(parts[0]);
			Entity e = clazz.newInstance();
			for(int i = 1; i < parts.length; i++)
			{
				String[] args = parts[i].split("=");
				e.setProperty(args[0], args[1]);
			}
			
			return e;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
