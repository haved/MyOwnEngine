package me.haved.game.entity;

import org.lwjgl.input.Keyboard;

import me.haved.engine.entity.MovingEntity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.engine.lib.Time;
import me.haved.engine.render.Camera;
import me.haved.engine.render.RenderEngine;
import me.haved.engine.world.World;
public class MyPlayerEntity extends MovingEntity implements PlayerEntity
{
	private static final float SPEED = 3000;
	private static final float GRAVITY = 3000;
	private static final float FRIC = 10;
	private static final float JUMP = 1400;
	
	public MyPlayerEntity()
	{
		this.width = 32;
		this.height = 64;
	}
	
	@Override
	public void update(World world)
	{
		ySpeed += GRAVITY * Time.delta();
		xSpeed -= xSpeed * FRIC * Time.delta();
		
		input(world);
		move(world);
		constrain(world);
	}
	
	private void input(World world)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			xSpeed -= Time.delta() * SPEED;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			xSpeed += Time.delta() * SPEED;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && y + height >= 1000)
		{
			ySpeed = -JUMP;
		}
	}
	
	private void constrain(World world)
	{
		if(x < 0)
		{
			x = 0;
			xSpeed = 0;
		}
		
		if(y < 0)
		{
			y = 0;
			ySpeed = 0;
		}
		
		if(x + width >= world.getWidth())
		{
			x = world.getWidth() - width;
			xSpeed = 0;
		}
		
		if(y + height >= world.getHeight())
		{
			y = world.getHeight() - height;
			ySpeed = 0;
		}
	}

	@Override
	public void render()
	{
		RenderEngine.setColor4f(1, 0.5f, 1, 1);
		RenderEngine.drawRect(x, y, width, height);
	}
	
	@Override
	public void updateCamera(World world, Camera cam)
	{
		float xScroll = this.getX() + (this.width - RenderEngine.getWidth()) / 2;
		float yScroll = this.getY() + (this.height - RenderEngine.getHeight()) / 2;
		
		xScroll = Math.max(Math.min(xScroll, world.getWidth() - RenderEngine.getWidth()), 0);
		yScroll = Math.max(Math.min(yScroll, world.getHeight() - RenderEngine.getHeight()), 0);
		
		cam.setCameraPosition(xScroll, yScroll);
	}
}
