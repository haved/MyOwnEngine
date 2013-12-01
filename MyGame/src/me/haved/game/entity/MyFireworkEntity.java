package me.haved.game.entity;

import java.util.ArrayList;

import me.haved.engine.effect.ColorDotParticle;
import me.haved.engine.entity.Entity;
import me.haved.engine.math.Vector3f;
import me.haved.engine.render.RenderEngine;

public class MyFireworkEntity extends Entity
{
	private int height = 200;
	private Vector3f color;
	private ArrayList<ColorDotParticle> particles;
	
	public MyFireworkEntity()
	{
		
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		RenderEngine.setColor4f(1, 1, 1, 1);
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "height":    setHeight(Integer.parseInt(value)); return true;
//		case "red":       color.red = Float.parseFloat(value); return true;
//		case "blue":      this.blue = Float.parseFloat(value); return true;
//		case "green":     this.green = Float.parseFloat(value); return true;
		default:return false;
		}
	}
}
