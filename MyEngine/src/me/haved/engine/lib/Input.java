package me.haved.engine.lib;

import me.haved.engine.core.Window;
import me.haved.engine.render.RenderEngine;

import org.lwjgl.input.Mouse;

public final class Input
{
	public static int getMouseX()
	{
		return (int)(Mouse.getX() / RenderEngine.getCanvasScaleX());
	}
	
	public static int getMouseY()
	{
		return (int)((Window.getHeight() - Mouse.getY()) / RenderEngine.getCanvasScaleY());
	}
	
	public static boolean isLMB()
	{
		return Mouse.isButtonDown(0);
	}
	
	public static boolean isMMB()
	{
		return Mouse.isButtonDown(1);
	}
	
	public static boolean isRMB()
	{
		return Mouse.isButtonDown(2);
	}
}
