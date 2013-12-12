package me.haved.engine.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public final class TextureReader
{
	public static Texture readPNGTexture(File f)
	{
		try
		{
			return readTexture(new FileInputStream(f), "PNG");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Texture readTexture(FileInputStream fis, String fileType)
	{
		try
		{
			return TextureLoader.getTexture(fileType, fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
