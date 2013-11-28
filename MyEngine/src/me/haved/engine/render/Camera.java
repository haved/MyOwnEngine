package me.haved.engine.render;

import me.haved.engine.math.Vector2i;

public class Camera
{
	private Vector2i pos;
	
	public Camera()
	{
		
	}
	
	public void setCameraPosition(Vector2i newPos)
	{
		this.pos = newPos;
	}
	
	public void setCameraPosition(int x, int y)
	{
		this.pos.setX(x);
		this.pos.setY(y);
	}
	
	public Vector2i getCameraPosition()
	{
		return this.pos;
	}
}
