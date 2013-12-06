package me.haved.engine.lib;

import me.haved.engine.core.Window;

import org.lwjgl.input.Mouse;

public final class Input
{
	public static int getMouseX()
	{
		return Mouse.getX();
	}
	
	public static int getMouseY()
	{
		return Window.getHeight() - Mouse.getY();
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
