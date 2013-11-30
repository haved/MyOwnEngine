package me.haved.engine.world;

import java.util.ArrayList;

import me.haved.engine.entity.Entity;

public class World
{
	private ArrayList<Entity> entities;
	
	public World()
	{
		entities = new ArrayList<Entity>();
	}
	
	public World(ArrayList<Entity> entities)
	{
		this.entities = entities;
	}
	
	public void update()
	{
		for(Entity e:entities)
		{
			e.update();
		}
	}
	
	public void render()
	{
		for(Entity e:entities)
		{
			e.render();
		}
	}
}
