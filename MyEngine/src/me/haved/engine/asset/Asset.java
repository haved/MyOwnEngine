package me.haved.engine.asset;

import java.io.File;

public abstract class Asset
{
	public abstract void loadAsset(File f);
	
	public abstract void unloadAsset();
	
	public abstract boolean isLoaded();
}
