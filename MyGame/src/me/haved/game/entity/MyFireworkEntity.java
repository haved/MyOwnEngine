package me.haved.game.entity;

import java.util.ArrayList;

import me.haved.engine.effect.Particle;
import me.haved.engine.entity.Entity;

public class MyFireworkEntity extends Entity
{
	private int height = 200;
	private float red = 0.5f;
	private float green = 0.8f;
	private float blue = 0.4f;
	private ArrayList<Particle> particles;
	
	public MyFireworkEntity()
	{
		
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public float getRed()
	{
		return red;
	}
	
	public void setRed(float red)
	{
		this.red = red;
	}
	
	public float getGreen()
	{
		return green;
	}
	
	public void setGreen(float green)
	{
		this.green = green;
	}
	
	public float getBlue()
	{
		return blue;
	}
	
	public void setBlue(float blue)
	{
		this.blue = blue;
	}
	
	@Override
	public boolean setProperty(String propertyName, String value)
	{
		if(super.setProperty(propertyName, value)) return true;
		
		switch(propertyName)
		{
		case "height":    setHeight(Integer.parseInt(value)); return true;
		case "red":       this.red = Float.parseFloat(value); return true;
		case "blue":      this.blue = Float.parseFloat(value); return true;
		case "green":     this.green = Float.parseFloat(value); return true;
		default:return false;
		}
	}
}
