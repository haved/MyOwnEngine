package me.haved.game.menu;

import java.util.HashMap;

import me.haved.engine.core.GameType;
import me.haved.engine.entity.Entity;
import me.haved.engine.entity.PlayerEntity;
import me.haved.game.core.MyGameType;

public class MyMenuGameType extends GameType
{
	private static HashMap<String, Class<? extends Entity>> entities = new HashMap<String, Class<? extends Entity>>();
	
	@Override
	public String getAssetLocation()
	{
		return "bin/content/menu/assets/";
	}

	@Override
	public String getWorldLocation()
	{
		return "bin/content/menu/worlds/";
	}

	@Override
	public Class<? extends Entity> getEntity(String name)
	{
		return entities.get(name);
	}

	@Override
	public Class<? extends PlayerEntity> getPlayerEntity()
	{
		return MyMenuPlayerEntity.class;
	}
	
	@Override
	public void inGameActionCalled(String action, Entity source)
	{
		getCanvas().setGameTypeToBeLoaded(MyGameType.class, "TestWorld");
	}
	
	static
	{
		initEntityList();
	}
	
	private static void initEntityList()
	{
		addEntityEntry(MyUIButton.class);
	}
	
	private static void addEntityEntry(Class<? extends Entity> entity)
	{
		entities.put(entity.getSimpleName(), entity);
	}
}
