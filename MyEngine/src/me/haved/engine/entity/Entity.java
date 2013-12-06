package me.haved.engine.entity;

import me.haved.engine.world.World;

public class Entity
{
	protected float x, y;
	
	public Entity()
	{
		
	}
	
	public Entity(float x, float y)
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
	
	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
	public boolean setProperty(String propertyName, String value)
	{
		/*if(super.setProperty(propertyName, value)) return true;*/
		
		switch(propertyName)
		{
		case "x":setX(Float.parseFloat(value)); return true;
		case "y":setY(Float.parseFloat(value)); return true;
		default:return false;
		}
	}
}
