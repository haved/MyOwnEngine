package me.haved.engine.entity;

import me.haved.engine.world.World;

public class Entity
{
	protected int x, y;
	
	public Entity()
	{
		
	}
	
	public Entity(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void update(World world)
	{
		
	}
	
	public void render()
	{
		
	}
	
	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}
	
	public boolean setProperty(String propertyName, String value)
	{
		switch(propertyName)
		{
		case "x":setX(Integer.parseInt(value)); return true;
		case "y":setY(Integer.parseInt(value)); return true;
		default:return false;
		}
	}
}
