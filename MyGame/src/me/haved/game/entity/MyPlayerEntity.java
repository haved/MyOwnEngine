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
		
		move(world);
		
		if(y + height >= 1000)
		{
			y = 1000 - height;
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
	public void updateCamera(Camera cam)
	{
		float xScroll = this.getX() + (this.width - RenderEngine.getWidth()) / 2;
		float yScroll = this.getY() + (this.height - RenderEngine.getHeight()) / 2;
		
		cam.setCameraPosition(xScroll, yScroll);
	}
}
