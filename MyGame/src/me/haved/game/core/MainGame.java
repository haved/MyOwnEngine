package me.haved.game.core;

import me.haved.engine.core.MainEngine;
import me.haved.engine.lib.InitInfo;

public class MainGame
{
	public static void main(String[] args)
	{
		InitInfo info = new InitInfo(MyGameType.class, "TestWorld");
		
		MainEngine.initEngine(info);
	}
}
