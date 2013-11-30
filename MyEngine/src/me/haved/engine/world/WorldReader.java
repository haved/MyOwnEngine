package me.haved.engine.world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;

public final class WorldReader
{
	public static World getWorldFromFile(File file, GameType gameType)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			ArrayList<Entity> entities = new ArrayList<Entity>();
			
			String s;
			String[] parts;
			Entity e;
			String[] args;
			while((s = reader.readLine()) != null)
			{
				if(s.startsWith("#")) continue;
				parts = s.split(",");
				Class<? extends Entity> clazz = gameType.getEntity(parts[0]);
				e = clazz.newInstance();
				for(int i = 1; i < parts.length; i++)
				{
					args = parts[i].split("=");
					e.setProperty(args[0], args[1]);
				}
				entities.add(e);
			}
			
			reader.close();
			
			return new World(entities);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
