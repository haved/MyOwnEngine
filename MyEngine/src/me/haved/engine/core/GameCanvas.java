package me.haved.engine.core;

public class GameCanvas
{
	public GameType gameType;
	
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
