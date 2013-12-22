package me.haved.engine.lib;

import me.haved.engine.core.GameType;

public class InitInfo
{
	public Class<? extends GameType> clazz;
	public String world;
	
	public String windowTitle = "My GameEngine";
	
	public int windowSizeX = 1024;
	public int windowSizeY = 768;
	
	public int canvasSizeX = 1024;
	public int canvasSizeY = 768;
	
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
