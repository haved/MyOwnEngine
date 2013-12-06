package me.haved.engine.lib;

public class FPSCounter
{
	private long lastFPSDisplay;
	private int frameCount;
	
	public void newFrame()
	{
		frameCount++;
		
		if(System.currentTimeMillis() - lastFPSDisplay > 1000)
		{
			System.out.println("FPS: " + frameCount);
			lastFPSDisplay = System.currentTimeMillis();
			frameCount = 0;
		}
	}
}
