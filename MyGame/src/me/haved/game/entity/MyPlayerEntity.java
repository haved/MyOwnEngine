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
	private static final float SPEED = 750;
	
	protected float rot;
	
	public MyPlayerEntity()
	{
		this.width = 10;
		this.height = 10;
	}
	
	@Override
	public void update(World world)
	{
		xSpeed = 0;
		ySpeed = 0;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT))
		{
			rot -= Time.delta() * 4;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
		{
			rot += Time.delta() * 4;
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP))
		{
			xSpeed = (float)Math.cos(rot) * SPEED;
			ySpeed = (float)Math.sin(rot) * SPEED;
		}
		
		move(world);
	}

	@Override
	public void render()
	{
		RenderEngine.pushTranslation(x + width/2, y + height/2);
		
		RenderEngine.setColor4f(1, 0.5f, 1, 1);
		RenderEngine.drawRect(-width/2, -height/2, width, height);
		
		RenderEngine.pushZRotation((float)Math.toDegrees(rot));
		
		RenderEngine.setColor4f(0.7f, 1, 0.5f, 1);
		RenderEngine.drawRect(-4, -4, 30, 8);
		
		RenderEngine.releaseTransform();
		RenderEngine.releaseTransform();
	}
	
	@Override
	public void updateCamera(Camera cam)
	{
		float xScroll = this.getX() + (this.width - RenderEngine.getWidth()) / 2;
		float yScroll = this.getY() + (this.height - RenderEngine.getHeight()) / 2;
		
		cam.setCameraPosition(xScroll, yScroll);
	}
}
