package me.haved.game.menu;

import me.haved.engine.entity.Entity;
import me.haved.engine.lib.Input;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;

public class MyUIButton extends Entity
{
	private int width, height;
	private String text;
	private String action;
	
	private boolean mouseOver;
	private boolean buttonDown;
	private boolean prevMouseState;
	
	public MyUIButton()
	{
		width = 300;
		height = 40;
	}
	
	@Override
	public void update(World world)
	{
		int mX = Input.getMouseX();
		int mY = Input.getMouseY();
		
		mouseOver = mX > getX() & mX < getX() + getWidth() & mY > getY() & mY < getY() + getHeight();
		
		if(Input.isLMB() & mouseOver & prevMouseState == false)
		{
			buttonDown = true;
		}
		
		if(buttonDown & Input.isLMB() == false)
		{
			buttonDown = false;
			if(mouseOver)
			{
				activate(world);
			}
		}
		
		prevMouseState = Input.isLMB();
	}
	
	@Override
	public void render()
	{
		if(mouseOver & buttonDown)
		{
			RenderEngine.setColor4f(1.0f, 1f, 0.5f, 1);
		}
		else if(mouseOver)
		{
			RenderEngine.setColor4f(1.0f, 0.8f, 0.6f, 1);
		}
		else
		{
			RenderEngine.setColor4f(1.0f, 0.7f, 0.4f, 1);
		}
		RenderEngine.drawRect(getX(), getY(), getWidth(), getHeight());
	}
	
	protected void activate(World world)
	{
		
	}
	
	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "width":this.setWidth(Integer.parseInt(value)); return true;
		case "height":this.setHeight(Integer.parseInt(value)); return true;
		case "text":this.setText(value); return true;
		case "action":this.setAction(value); return true;
		default:return false;
		}
	}
}
