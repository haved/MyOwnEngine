package me.haved.engine.lib;

public final class Time
{
	private static final boolean SHOW_FPS = true;
	
	private static int frame;
	private static long startFPSCount;
	
	private static long startTime;
	private static long deltaTime;
	
	public static void startDeltaTimer()
	{
		startTime = System.currentTimeMillis();
	}
	
	public static void stopDeltaTimer()
	{
		setDeltaTime(System.currentTimeMillis() - startTime);
		if(SHOW_FPS)
		{
			frame++;
			
			if(System.currentTimeMillis() - startFPSCount > 1000)
			{
				System.out.println("FPS:" + frame);
				startFPSCount = System.currentTimeMillis();
				frame = 0;
			}
		}
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
	
	public static void delay(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
