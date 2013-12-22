package me.haved.engine.core;

import java.io.File;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import me.haved.engine.asset.AssetLib;
import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.render.Camera;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;
import me.haved.engine.world.WorldUniverse;

public class GameCanvas
{
	private boolean hasShownLoading;
	private boolean showLoading;
	private Class<? extends GameType> nextGameType;
	private String nextWorld;
	
	private Camera cam;
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
		world.update(playerEntity);
		playerEntity.updateCamera(world, cam);
	}
	
	public void render()
	{
		RenderEngine.pushCanvasTransform();
		
		if(showLoading)
		{
			renderLoadingScreen();
		}
		else
		{
			renderWorld();
		}
		
		RenderEngine.releaseTransform();
	}
	
	private void renderWorld()
	{
		world.render(playerEntity, cam);
	}
	
	private void renderLoadingScreen()
	{
		hasShownLoading = true;
		
		RenderEngine.setColor4f(0.552f,	0.933f, 0.933f, 1);
		RenderEngine.drawRect(0, 0, RenderEngine.getWidth(), RenderEngine.getHeight());
		
		if(nextGameType != null)
		{
			//Is currently loading.
			RenderEngine.drawText(RenderEngine.getWidth() - 200, RenderEngine.getHeight() - 50, "Loading. Please wait...", Color.black);
		}
		else
		{
			//Is done loading, hit enter.
			RenderEngine.drawText(RenderEngine.getWidth() - 200, RenderEngine.getHeight() - 50, "Press 'enter' to continue", Color.black);
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
			
			cam = new Camera();
			
			AssetLib.unloadAssets(); //If there are any previous assets loaded.
			AssetLib.loadAssets(gameType.getAssetLocation());
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
