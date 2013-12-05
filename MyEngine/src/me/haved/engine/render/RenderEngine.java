package me.haved.engine.render;

import static org.lwjgl.opengl.GL11.*;

public final class RenderEngine
{
	/**The init method for the RenderEngine
	 * has to be called after the OpenGL window is initialized*/
	public static void init()
	{
		
	}
	
	public static void initOrtho(int width, int height)
	{
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
