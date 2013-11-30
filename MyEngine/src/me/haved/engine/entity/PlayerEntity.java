package me.haved.engine.entity;

import me.haved.engine.render.Camera;

public interface PlayerEntity
{
	public void update();
	
	public void render();
	
	public void updateCamera(Camera cam);
}
