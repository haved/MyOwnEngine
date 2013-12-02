package me.haved.engine.entity;

import me.haved.engine.lib.Time;
import me.haved.engine.world.World;

public class MovingEntity extends Entity
{
	protected float slowX;
	protected float slowY;
	
	protected float xSpeed;
	protected float ySpeed;
	
	public void move(World world)
	{
		slowX = xSpeed * Time.delta();
	}
}
