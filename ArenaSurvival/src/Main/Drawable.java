package Main;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Drawable 
{	
	protected int height, width;
	protected Color color;
	protected BufferedImage image;
	protected int posX, posY;
      
	
	//YOU GIVE THE PARAMETERS TO SET SOME PROPERTIES
	
	public Drawable(int x, int y, int w, int h, Color c)
	{
		height = h;
		width = w;
		color = c;
		posX = x;
		posY = y;
		
		loadImage();
	}
	
	//ONLY GETTERS BELOW
	
	public int getHeight() 
	{
		return height;
	}
	
	public int getWidth ()
	{
		return width;
	}
	
	public Color getColor () 
	{
		return color;
	}
	
	public BufferedImage getImage() 
	{
		return image;
	}
	
	public int getPosX ()
	{
		return posX;
	}
	
	public int getPosY ()
	{
		return posY;
	}
	
	public Rectangle getRectangle ()
	{
		return new Rectangle (posX, posY, width, height);
	}
	
	protected void loadImage() //USED TO LOAD BUFFEREDIMAGE & GIVES RIGHT WIDTH/HEIGHT
	{
		
	}
	
}