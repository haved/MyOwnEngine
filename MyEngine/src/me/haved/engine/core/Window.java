package me.haved.engine.core;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public final class Window
{
	public static int fps;
	
	public static void setFps(int fps)
	{
		Window.fps = fps;
	}
	
	public static int getFps()
	{
		return fps;
	}
	
	public static void update()
	{
		Display.update();
	}
	
	public static void sync()
	{
		if(fps > 0)
		{
			Display.sync(fps);
		}
		else
		{
			Display.sync(9999);
		}
	}
	
	public static void setTitle(String title)
	{
		Display.setTitle(title);
	}
	
	public static void setVSync(boolean vsync)
	{
		Display.setVSyncEnabled(vsync);
	}
	
	public static void setResizable(boolean resizable)
	{
		Display.setResizable(resizable);
	}
	
	public static void setFullscreen(boolean fullscreen)
	{
		try {
			Display.setFullscreen(fullscreen);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	public static void create(int width, int height)
	{
		try
		{
			initDisplayWindow(width, height);
		}
		catch(Exception e)
		{
			new Exception("Unnable to open window, engine can't start!");
			System.exit(0);
		}
	}
	
	private static void initDisplayWindow(int width, int height) throws Exception
	{
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
		Mouse.create();
		Keyboard.create();
	}
	
	public static void setSize(int width, int height)
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(width, height));
		}
		catch(Exception e)
		{
			new Exception("Unnable to rezise the window! - me.haved.engine.core.Window.setSize()");
		}
	}
	
	public static boolean isCloseRequested()
	{
		return Display.isCloseRequested();
	}
	
	public static boolean isActive()
	{
		return Display.isActive();
	}
	
	public static int getWidth()
	{
		return Display.getWidth();
	}
	
	public static int getHeight()
	{
		return Display.getHeight();
	}
	
	public static void dispose()
	{
		Display.destroy();
		Mouse.destroy();
		Keyboard.destroy();
	}
}