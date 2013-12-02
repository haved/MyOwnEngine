package me.haved.engine.entity;

import me.haved.engine.lib.Time;
import me.haved.engine.world.World;

public class MovingEntity extends Entity
{	
	protected float xSpeed;
	protected float ySpeed;
	
	public void move(World world)
	{
		x += xSpeed * Time.delta() / 1000;
		y += ySpeed * Time.delta() / 1000;
	}
}
