package me.haved.engine.effect;

public class Particle
{
	private int life;
	private int x;
	private int y;
	private int xSpeed;
	private int ySpeed;
	
	public Particle(int x, int y, int xSpeed, int ySpeed, int life)
	{
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public void damage()
	{
		life--;
	}
	
	public boolean isDead()
	{
		return life <= 0;
	}
	
	public int getLife()
	{
		return life;
	}

	public void setLife(int life)
	{
		this.life = life;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getxSpeed()
	{
		return xSpeed;
	}

	public void setxSpeed(int xSpeed)
	{
		this.xSpeed = xSpeed;
	}

	public int getySpeed()
	{
		return ySpeed;
	}

	public void setySpeed(int ySpeed)
	{
		this.ySpeed = ySpeed;
	}
}
