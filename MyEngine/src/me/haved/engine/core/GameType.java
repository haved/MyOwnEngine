package me.haved.engine.core;

import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;

public abstract class GameType
{
	private GameCanvas currentCanvas;
	
	public void setCanvas(GameCanvas gameCanvas)
	{
		this.currentCanvas = gameCanvas;
	}
	
	protected GameCanvas getCanvas()
	{
		return currentCanvas;
	}
	
	public abstract String getAssetLocation();
	
	public abstract String getWorldLocation();
	
	public abstract Class<? extends Entity> getEntity(String name);
	
	public abstract Class<? extends PlayerEntity> getPlayerEntity();

	public abstract void inGameActionCalled(String action, Entity source);
}