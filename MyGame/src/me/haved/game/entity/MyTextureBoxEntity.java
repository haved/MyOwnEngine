package me.haved.game.entity;

import me.haved.engine.core.Window;
import me.haved.engine.lib.Time;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;

public class MyTextureBoxEntity extends MyBoxEntity
{
	@Override
	public void update(World world)
	{
		ySpeed += 3 * Time.delta();
		
		if(y < 0)
		{
			y = 0;
			ySpeed = -ySpeed;
		}
		
		if(y + height > RenderEngine.getHeight())
		{
			y=Window.getHeight() - height;
			ySpeed =-ySpeed;
		}
		
		if(x < 0)
		{
			x = 0;
			xSpeed = -xSpeed;
		}
		
		if(x + width > RenderEngine.getWidth())
		{
			x=Window.getWidth() - width;
			xSpeed =-xSpeed;
		}
		
		move(world);
	}
	
	@Override
	public void render()
	{
		RenderEngine.setColor4f(red, green, blue, 1.0f);
		RenderEngine.bindTexture("test.png");
		RenderEngine.drawTextureRect(getX(), getY(), getWidth(), getHeight());
	}
}
