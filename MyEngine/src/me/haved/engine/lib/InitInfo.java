package me.haved.engine.lib;

import me.haved.engine.core.GameType;

public class InitInfo
{
	public Class<? extends GameType> clazz;
	public String world;
	
	public String windowTitle = "My GameEngine";
	
	public int windowResX = 1024;
	public int windowResY = 768;
	
	public boolean fullscreen = true;
	
	public int fps = 9999;
	public boolean vsych = false;
	public boolean resizable = false;
	
	public InitInfo(Class<? extends GameType> clazz, String world)
	{
		this.clazz = clazz;
		this.world = world;
	}
}
