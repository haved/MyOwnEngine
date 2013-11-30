package me.haved.game.entity;

import me.haved.engine.entity.Entity;
import me.haved.engine.render.RenderEngine;

public class MyBoxEntity extends Entity
{
	private int width = 60;
	private int height = 60;
	
	private float red = 1f;
	private float green = 0.5f;
	private float blue = 0.5f;
	
	public MyBoxEntity()
	{
		
	}
	
	@Override
	public void render()
	{
		RenderEngine.setColor4f(red, green, blue, 1.0f);
		RenderEngine.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "width":     setWidth(Integer.parseInt(value)); return true;
		case "height":    setHeight(Integer.parseInt(value)); return true;
		case "red":       this.red = Float.parseFloat(value); return true;
		case "blue":      this.blue = Float.parseFloat(value); return true;
		case "green":     this.green = Float.parseFloat(value); return true;
		default:return false;
		}
	}
}
