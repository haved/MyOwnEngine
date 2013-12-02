package me.haved.engine.lib;

public final class Time
{
	private static long startTime;
	private static long deltaTime;
	
	public static void startDeltaTimer()
	{
		startTime = System.currentTimeMillis();
	}
	
	public static void stopDeltaTimer()
	{
		setDeltaTime(System.currentTimeMillis() - startTime);
	}
	
	public static void setDeltaTime(long newDelta)
	{
		Time.deltaTime = newDelta;
	}
	
	public static long getDeltaTime()
	{
		return Time.deltaTime;
	}
	
	public static long delta()
	{
		return getDeltaTime();
	}
}
