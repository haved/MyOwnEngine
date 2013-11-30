package me.haved.engine.core;

import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.world.World;

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
		
	}
	
	public void render()
	{
		
	}
	
	public void loadGameType(Class<? extends GameType> clazz)
	{
		try
		{
			gameType = clazz.newInstance();
			playerEntity = gameType.getPlayerEntity().newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
	public void setWorld(String world)
	{
		
	}
}
