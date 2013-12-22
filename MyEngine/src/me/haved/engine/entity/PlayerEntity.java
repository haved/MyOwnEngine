package me.haved.engine.entity;

import me.haved.engine.render.Camera;
import me.haved.engine.world.World;

public interface PlayerEntity
{
	public void update(World world);
	
	public void render();
	
	public void updateCamera(World world, Camera cam);
}
