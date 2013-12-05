package me.haved.game.entity;

import me.haved.engine.entity.Entity;
import me.haved.engine.lib.Time;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;

public class SpinningBoxEntity extends Entity
{
	private float value;
	
	private float speed;
	private float radius;
	
	public SpinningBoxEntity()
	{
		this.speed = 1.0f;
		this.radius = 140.0f;
	}
	
	@Override
	public void update(World world)
	{
		super.update(world);
		
		value += speed * Time.delta() / 1000f;
	}
	
	@Override
	public void render()
	{
		RenderEngine.pushTranslation(getX(), getY());
		
		RenderEngine.setColor4f(1.0f, 0.5f, 0.7f, 1.0f);
		RenderEngine.drawRect(((float)Math.cos(value)) * radius - 5, ((float)Math.sin(value)) * radius - 5, 20, 20);
		
		RenderEngine.releaseTransform();
	}
	
	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}

	public float getRadius()
	{
		return radius;
	}

	public void setRadius(float radius)
	{
		this.radius = radius;
	}

	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "speed": this.setSpeed(Integer.parseInt(value)); return true;
		case "radius": this.setRadius(Integer.parseInt(value)); return true;
		default:return false;
		}
	}
}
