package me.haved.game.core;

import me.haved.engine.core.MainEngine;
import me.haved.engine.lib.InitInfo;
import me.haved.game.menu.MyMenuGameType;

public class MainGame
{
	public static void main(String[] args)
	{
		InitInfo info = new InitInfo(MyMenuGameType.class, "MenuScreen");
		
		MainEngine.initEngine(info);
	}
}
