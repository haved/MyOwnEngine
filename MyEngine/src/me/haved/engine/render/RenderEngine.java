package me.haved.engine.render;

import static org.lwjgl.opengl.GL11.*;

public final class RenderEngine
{
	/**The init method for the RenderEngine
	 * has to be called after the OpenGL window is initialized*/
	public static void init()
	{
		
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
}
