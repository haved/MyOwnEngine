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
		if(particles == null)
		{
			
		}
	}
	
	public void render()
	{
		RenderEngine.setColor4f(1, 1, 1, 1);
		RenderEngine.drawRect(getX()-5, getY()-10, 10, 20);
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
		case "red":       this.color.setX(Float.parseFloat(value)); return true;
		case "blue":      this.color.setY(Float.parseFloat(value)); return true;
		case "green":     this.color.setZ(Float.parseFloat(value)); return true;
		default:return false;
		}
	}
}
