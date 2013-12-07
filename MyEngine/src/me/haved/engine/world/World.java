package me.haved.engine.world;

import java.util.ArrayList;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;

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
	
	public void update()
	{
		for(Entity e:entities)
		{
			e.update(this);
		}
	}
	
	public void render()
	{
		for(Entity e:entities)
		{
			e.render();
		}
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
