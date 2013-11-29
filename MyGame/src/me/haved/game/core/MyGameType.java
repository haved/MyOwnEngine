package me.haved.game.core;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.game.entity.MyPlayerEntity;

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
	public Class<? extends Entity> getEntity(String name)
	{
		return null;
	}

	@Override
	public Class<? extends PlayerEntity> getPlayerEntity()
	{
		return MyPlayerEntity.class;
	}
}
