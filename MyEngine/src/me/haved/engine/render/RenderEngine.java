package me.haved.engine.render;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public final class RenderEngine
{
	private static TrueTypeFont defaultFont;
	private static TrueTypeFont customFont;
	
	/**The init method for the RenderEngine
	 * has to be called after the OpenGL window is initialized*/
	public static void init()
	{
		defaultFont = new TrueTypeFont(new Font("Dialog", Font.PLAIN, 18), true);
	}
	
	public static void initOrtho(int width, int height)
	{
		glShadeModel(GL_SMOOTH);
		glDisable(GL_DEPTH_TEST);
		glDisable(GL_LIGHTING);
		
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, height, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public static void clearColorBuffer()
	{
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void setColor4f(float red, float green, float blue, float alpha)
	{
		glColor4f(red, green, blue, alpha);
	}
	
	public static void drawRect(float x, float y, float width, float height)
	{
		glPushMatrix();
		
		glTranslatef(x, y, 0);
		
		glBegin(GL_QUADS);
		{
			glVertex2f(0,     0);
			glVertex2f(width, 0);
			glVertex2f(width, height);
			glVertex2f(0,     height);
		}
		glEnd();
		
		glPopMatrix();
	}
	
	public static void setCustomFont(TrueTypeFont font)
	{
		RenderEngine.customFont = font;
	}
	
	public static void drawText(float x, float y, String text, Color color)
	{
		drawText(x, y, text, color, defaultFont);
	}
	
	public static void drawCustomFontText(float x, float y, String text, Color color)
	{
		drawText(x, y, text, color, customFont);
	}
	
	private static void drawText(float x, float y, String chars, Color color, TrueTypeFont font)
	{
		glEnable(GL_BLEND);
		font.drawString(x, y, chars, color);
		glDisable(GL_BLEND);
	}
	
	public static void pushTranslation(float x, float y)
	{
		glPushMatrix();
		glTranslatef(x, y, 0);
	}
	
	public static void releaseTransform()
	{
		glPopMatrix();
	}
}
