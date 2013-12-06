package me.haved.game.menu;

import me.haved.engine.entity.Entity;

public class MyUIButton extends Entity
{
	private int width, height;
	private String text;
	private String action;
	
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
