package me.haved.engine.effect;

import me.haved.engine.math.Vector3f;

public class ColorDotParticle extends Particle
{
	private Vector3f color;
	
	public ColorDotParticle(int x, int y, int xSpeed, int ySpeed, int life, Vector3f color)
	{
		super(x, y, xSpeed, ySpeed, life);
		this.setColor(color);
	}

	public Vector3f getColor()
	{
		return color;
	}

	public void setColor(Vector3f color)
	{
		this.color = color;
	}
}
