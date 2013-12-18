package me.haved.game.entity;

import me.haved.engine.entity.MovingEntity;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;

public class MyBoxEntity extends MovingEntity
{
	protected int width = 60;
	protected int height = 60;
	
	protected float red = 1f;
	protected float green = 1f;
	protected float blue = 1f;
	
	public MyBoxEntity()
	{
		
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		
		move(world);
	}
	
	@Override
	public void render()
	{
		RenderEngine.setColor4f(red, green, blue, 1.0f);
		RenderEngine.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "red":       this.red = Float.parseFloat(value); return true;
		case "blue":      this.blue = Float.parseFloat(value); return true;
		case "green":     this.green = Float.parseFloat(value); return true;
		default:return false;
		}
	}
}
