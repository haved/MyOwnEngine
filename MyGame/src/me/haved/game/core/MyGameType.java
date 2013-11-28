package me.haved.game.core;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;

public class MyGameType extends GameType
{
	@Override
	public String getAssetLocation()
	{
		return null;
	}

	@Override
	public String getWorldLocation()
	{
		return null;
	}

	@Override
	public Entity getEntity(String name)
	{
		return null;
	}

	@Override
	public PlayerEntity getPlayerEntity()
	{
		return null;
	}
}
