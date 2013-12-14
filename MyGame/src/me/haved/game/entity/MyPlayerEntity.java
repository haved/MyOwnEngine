package me.haved.game.entity;

import org.lwjgl.input.Keyboard;

import me.haved.engine.entity.MovingEntity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.render.Camera;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;
public class MyPlayerEntity extends MovingEntity implements PlayerEntity
{
	private static final float speed = 500;
	
	@Override
	public void update(World world)
	{
		xSpeed = 0;
		ySpeed = 0;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			xSpeed = -speed;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			xSpeed = speed;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			ySpeed = -speed;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
		{
			ySpeed = speed;
		}
		
		move(world);
	}

	@Override
	public void render()
	{
		RenderEngine.setColor4f(1, 0.5f, 1, 1);
		RenderEngine.drawRect(x, y, 32, 64);
	}
	
	@Override
	public void updateCamera(Camera cam)
	{
		
	}
}
