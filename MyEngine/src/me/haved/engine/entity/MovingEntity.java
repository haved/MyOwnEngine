package me.haved.engine.entity;

import me.haved.engine.lib.Time;
import me.haved.engine.world.World;

public class MovingEntity extends Entity
{	
	protected float xSpeed;
	protected float ySpeed;
	
	public void move(World world)
	{
		x += xSpeed * Time.delta();
		y += ySpeed * Time.delta();
	}
	
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "xSpeed":this.xSpeed = Float.parseFloat(value); return true;
		case "ySpeed":this.ySpeed = Float.parseFloat(value); return true;
		default:return false;
		}
	}
}
