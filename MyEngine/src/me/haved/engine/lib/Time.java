package me.haved.engine.lib;

public final class Time
{
	private static float startTime;
	private static float deltaTime;
	
	public static void startDeltaTimer()
	{
		startTime = System.currentTimeMillis();
	}
	
	public static void stopDeltaTimer()
	{
		setDeltaTime(System.currentTimeMillis() - startTime);
	}
	
	public static void setDeltaTime(float newDelta)
	{
		Time.deltaTime = newDelta;
	}
	
	public static float getDeltaTime()
	{
		return Time.deltaTime;
	}
	
	public static float delta()
	{
		return getDeltaTime();
	}
}
