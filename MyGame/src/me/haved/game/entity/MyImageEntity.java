package me.haved.game.entity;

import me.haved.engine.entity.Entity;
import me.haved.engine.render.RenderEngine;

public class MyImageEntity extends Entity
{
	private String img;
	
	@Override
	public void render()
	{
		RenderEngine.bindTexture(img);
		RenderEngine.clearColor();
		RenderEngine.drawTextureRect(x, y, width, height);
	}
	
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "src": this.img = value; return true;
		default:return false;
		}
	}
}
