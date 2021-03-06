package me.haved.game.core;

import me.haved.engine.core.MainEngine;
import me.haved.engine.lib.InitInfo;
import me.haved.game.menu.MyMenuGameType;

public class MainGame
{
	public static void main(String[] args)
	{
		InitInfo info = new InitInfo(MyMenuGameType.class, "MenuScreen");
		info.fps = 140;
		info.canvasSizeX = 1600;
		info.canvasSizeY = 900;
		info.windowSizeX = 1600;
		info.windowSizeY = 900;
		
		MainEngine.initEngine(info);
	}
}