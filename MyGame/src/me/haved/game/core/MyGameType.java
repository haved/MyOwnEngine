package me.haved.game.core;

import java.util.HashMap;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.game.entity.*;

public class MyGameType extends GameType
{
	private static HashMap<String, Class<? extends Entity>> entities = new HashMap<String, Class<? extends Entity>>();
	
	public MyGameType()
	{
		
	}
	
	@Override
	public String getAssetLocation()
	{
		return "bin/content/game/assets/";
	}

	@Override
	public String getWorldLocation()
	{
		return "bin/content/game/worlds/";
	}

	@Override
	public Class<? extends Entity> getEntity(String name)
	{
		return entities.get(name);
	}

	@Override
	public Class<? extends PlayerEntity> getPlayerEntity()
	{
		return MyPlayerEntity.class;
	}
	
	@Override
	public void inGameActionCalled(String action, Entity source)
	{
		
	}
	
	static
	{
		initEntityList();
	}
	
	private static void initEntityList()
	{
		addEntityEntry(MyBoxEntity.class);
		addEntityEntry(SpinningBoxEntity.class);
	}
	
	private static void addEntityEntry(Class<? extends Entity> entity)
	{
		entities.put(entity.getSimpleName(), entity);
	}
}
