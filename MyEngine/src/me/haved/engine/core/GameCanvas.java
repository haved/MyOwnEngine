package me.haved.engine.core;

import java.io.File;

import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.world.World;
import me.haved.engine.world.WorldUniverse;

public class GameCanvas
{
	private GameType gameType;
	private PlayerEntity playerEntity;
	private World world;
	
	public GameCanvas()
	{
		
	}
	
	public void update()
	{
		playerEntity.update();
		world.update();
	}
	
	public void render()
	{
		playerEntity.render();
		world.render();
	}
	
	public void loadGameType(Class<? extends GameType> clazz)
	{
		try
		{
			gameType = clazz.newInstance();
			playerEntity = gameType.getPlayerEntity().newInstance();
			WorldUniverse.loadWorlds(new File(gameType.getWorldLocation()), gameType);
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
	public void setWorld(String worldName)
	{
		world = WorldUniverse.getWorld(worldName);
	}
}
