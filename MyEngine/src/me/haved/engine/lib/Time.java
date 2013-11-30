package me.haved.engine.lib;

public class Time
{
	private float deltaTime;
	
	public void setDeltaTime(float newDelta)
	{
		this.deltaTime = newDelta;
	}
	
	public float getDeltaTime()
	{
		return this.deltaTime;
	}
	
	public float delta()
	{
		return getDeltaTime();
	}
}
