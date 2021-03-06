package me.haved.engine.entity;

import me.haved.engine.world.World;

public class Entity
{
	private boolean isAlive = true;
	
	protected float x, y, width, height;
	
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
	
	public void kill()
	{
		isAlive = false;
	}
	
	public boolean isAlive()
	{
		return isAlive;
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
	
	public float getWidth()
	{
		return width;
	}

	public void setWidth(float width)
	{
		this.width = width;
	}

	public float getHeight()
	{
		return height;
	}

	public void setHeight(float height)
	{
		this.height = height;
	}

	public boolean setProperty(String propertyName, String value)
	{
		/*if(super.setProperty(propertyName, value)) return true;*/
		
		switch(propertyName)
		{
		case "x":		setX(Float.parseFloat(value)); return true;
		case "y":		setY(Float.parseFloat(value)); return true;
		case "width":   setWidth(Float.parseFloat(value)); return true;
		case "height":  setHeight(Float.parseFloat(value)); return true;
		default:return false;
		}
	}
}
