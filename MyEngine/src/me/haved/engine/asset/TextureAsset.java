package me.haved.engine.asset;

import java.io.File;

import me.haved.engine.lib.TextureReader;

import org.newdawn.slick.opengl.Texture;

public class TextureAsset extends Asset
{
	private Texture texture;
	
	@Override
	public void loadAsset(File f)
	{
		if(f.getName().endsWith(".png"))
		{
			texture = TextureReader.readPNGTexture(f);
		}
	}

	@Override
	public void unloadAsset()
	{
		if(texture != null)
		{
			texture.release();
		}
	}
	
	public void bindTexture()
	{
		if(texture != null)
		{
			texture.bind();
		}
	}
	
	@Override
	public boolean isLoaded()
	{
		return texture != null;
	}
}
