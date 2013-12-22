package me.haved.game.menu;

import org.newdawn.slick.Color;

import me.haved.engine.entity.Entity;
import me.haved.engine.lib.Input;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;

public class MyUIButton extends Entity
{
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
		RenderEngine.clearColor();
		RenderEngine.bindTexture("gui.png");
		
		int texY = 0;
		int textShift = 0;
		
		if(mouseOver & buttonDown)
		{
			texY = 16 * 2;
			textShift = 2;
		}
		else if(mouseOver)
		{
			texY = 16;
		}
		
		RenderEngine.drawTextureRect(x, y, width, height, 0, texY, 104, texY + 16);
		RenderEngine.drawText(x + (width - RenderEngine.getTextWidth(text)) / 2 + textShift, y + (height - RenderEngine.getTextHeight(text)) / 2 + textShift, text, Color.white);
	}
	
	protected void activate(World world)
	{
		world.sendGameAction(action, this);
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
		case "text":this.setText(value); return true;
		case "action":this.setAction(value); return true;
		default:return false;
		}
	}
}
