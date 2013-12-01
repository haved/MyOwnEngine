package me.haved.engine.core;

import me.haved.engine.lib.InitInfo;
import me.haved.engine.render.RenderEngine;

public class MainEngine
{
	private static MainEngine instance;
	
	private GameCanvas canvas;
	
	public MainEngine()
	{
		canvas = new GameCanvas();
	}
	
	public void init(InitInfo info)
	{
		Window.create(info.windowResX, info.windowResY);
		Window.setTitle(info.windowTitle);
		Window.setResizable(info.resizable);
		Window.setVSync(info.vsych);
		
		RenderEngine.initOrtho(info.windowResX, info.windowResY);
		
		canvas.loadGameType(info.clazz);
		canvas.setWorld(info.world);
	}
	
	public void start()
	{
		while(Window.isCloseRequested() == false)
		{
			RenderEngine.clearColorBuffer();
			canvas.update();
			canvas.render();
			Window.update();
		}
		
		Window.dispose();
	}
	
	public static void initEngine(InitInfo info)
	{
		if(info == null || (info.clazz == null | info.world == null))
		{
			new Exception("No initialisationinfo passed to initEngine!");
			System.exit(1);
		}
		
		instance = new MainEngine();
		instance.init(info);
		instance.start();
		
		System.out.println("Natrual shutdown!");
		System.exit(0);
	}
}
