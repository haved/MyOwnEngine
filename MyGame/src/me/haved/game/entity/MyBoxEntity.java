package me.haved.game.entity;

import me.haved.engine.entity.Entity;

public class MyBoxEntity extends Entity
{
	@Override
	public void render()
	{
		System.out.println("MyBoxIsRendering!");
	}
}
