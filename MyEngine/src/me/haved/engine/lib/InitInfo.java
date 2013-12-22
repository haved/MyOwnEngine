package me.haved.engine.lib;

import me.haved.engine.core.GameType;

public class InitInfo
{
	public Class<? extends GameType> clazz;
	public String world;
	
	public String windowTitle = "My GameEngine";
	/*List of 16:9 resolutions:
	 * 1024  :  576
	 * 1280  :  720
	 * 1600  :  900
	 * 1920  :  1080
	 * */
	public int windowSizeX = 1024;
	public int windowSizeY = 576;
	
	public int canvasSizeX = 1600;
	public int canvasSizeY = 900;
	
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
