package me.haved.engine.world;

import java.util.ArrayList;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.render.Camera;
import me.haved.engine.render.RenderEngine;

public class World
{
	private GameType gameType;
	
	private ArrayList<Entity> entities;
	
	public World(GameType gameType)
	{
		this(gameType, new ArrayList<Entity>());
	}
	
	public World(GameType gameType, ArrayList<Entity> entities)
	{
		this.gameType = gameType;
		this.entities = entities;
	}
	
	public void update(PlayerEntity player)
	{
		for(Entity e:entities)
		{
			e.update(this);
		}
		
		player.update(this);
	}
	
	public void render(PlayerEntity player, Camera cam)
	{
		RenderEngine.pushTranslation(-cam.getCameraPosition().getX(), -cam.getCameraPosition().getY());
		
		for(Entity e:entities)
		{
			e.render();
		}
		
		player.render();
		
		RenderEngine.releaseTransform();
	}
	
	public void sendGameAction(String action, Entity source)
	{
		getGameType().inGameActionCalled(action, source);
	}
	
	public GameType getGameType()
	{
		return gameType;
	}
}
