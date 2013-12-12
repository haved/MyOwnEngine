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
		
		if(y + height > Window.getHeight())
		{
			ySpeed =-ySpeed;
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
