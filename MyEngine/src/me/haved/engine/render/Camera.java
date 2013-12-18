package me.haved.engine.render;

import me.haved.engine.math.Vector2f;

public class Camera
{
	private Vector2f pos;
	
	public Camera()
	{
		pos = new Vector2f(0, 0);
	}
	
	public void setCameraPosition(Vector2f newPos)
	{
		this.pos = newPos;
	}
	
	public void setCameraPosition(float x, float y)
	{
		this.pos.setX(x);
		this.pos.setY(y);
	}
	
	public Vector2f getCameraPosition()
	{
		return this.pos;
	}
}
