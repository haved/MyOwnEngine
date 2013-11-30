package me.haved.game.core;

import java.util.HashMap;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.game.entity.MyBoxEntity;
import me.haved.game.entity.MyPlayerEntity;

public class MyGameType extends GameType
{
	private static HashMap<String, Class<? extends Entity>> entities = new HashMap<String, Class<? extends Entity>>();
	
	public MyGameType()
	{
		
	}
	
	@Override
	public String getAssetLocation()
	{
		return "bin/content/assets/";
	}

	@Override
	public String getWorldLocation()
	{
		return "bin/content/worlds/";
	}

	@Override
	public Class<? extends Entity> getEntity(String name)
	{
		return entities.get(name.trim());
	}

	@Override
	public Class<? extends PlayerEntity> getPlayerEntity()
	{
		return MyPlayerEntity.class;
	}
	
	static
	{
		initEntityList();
	}
	
	private static void initEntityList()
	{
		entities.put("MyBoxEntity", MyBoxEntity.class);
	}
}
