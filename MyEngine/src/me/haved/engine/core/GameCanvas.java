package me.haved.engine.core;

import java.io.File;

import org.lwjgl.input.Keyboard;

import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;
import me.haved.engine.world.WorldUniverse;

public class GameCanvas
{
	private boolean hasShownLoading;
	private boolean showLoading;
	private Class<? extends GameType> nextGameType;
	private String nextWorld;
	
	private GameType gameType;
	private PlayerEntity playerEntity;
	private World world;
	
	public GameCanvas()
	{
		
	}
	
	public void update()
	{
		tryLoadNextGameType(); //Only if it has one!
		
		if(showLoading) //If it is showing the loading screen.
		{
			waitForInput(); //Will see if the player wants to end the loading screen.
		}
		
		if(!showLoading) //If it is no longer true, tick the world;
		{
			updateWorld();
		}
	}
	
	private void tryLoadNextGameType()
	{
		if(nextGameType != null & hasShownLoading == true)
		{
			loadGameType(nextGameType);
			setWorld(nextWorld);
			
			nextGameType = null;
			nextWorld = null;
		}
	}
	
	private void waitForInput()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_RETURN))
		{
			showLoading = false;
		}
	}
	
	private void updateWorld()
	{
		playerEntity.update(world);
		world.update();
	}
	
	public void render()
	{
		if(showLoading)
		{
			renderLoadingScreen();
		}
		else
		{
			renderWorld();
		}
	}
	
	private void renderWorld()
	{
		playerEntity.render();
		world.render();
	}
	
	private void renderLoadingScreen()
	{
		hasShownLoading = true;
		if(nextGameType != null)
		{
			//Is currently loading.
			RenderEngine.setColor4f(1, 1, 0.5f, 1);
			RenderEngine.drawRect(100, 300, 400, 200);
		}
		else
		{
			//Is done loading, hit enter.
			RenderEngine.setColor4f(1, 0.5f, 1, 1);
			RenderEngine.drawRect(100, 300, 400, 200);
		}
	}
	
	
	public void setGameTypeToBeLoaded(Class<? extends GameType> clazz, String world)
	{
		this.nextGameType = clazz;
		this.nextWorld = world;
		this.showLoading = true;
	}
	
	
	public void loadGameType(Class<? extends GameType> clazz)
	{
		try
		{
			gameType = clazz.newInstance();
			gameType.setCanvas(this);
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
