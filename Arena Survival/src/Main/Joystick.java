package Main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.Action;

public class Joystick extends Drawable
{

	private Boolean isVisible;
	private int screenWidth;
	
	public Joystick(int x, int y, int h, int w, Color c) {
		super(x, y, h, w, c);
		isVisible = false;
	}
	
	public Boolean isVisible ()
	{
		return isVisible;
	}
	
	public void keyHappened (int key, Player p)
	{
		isVisible = true;
		//SHOULD CHANGE LOOK HERE!!!!!!!!!!!!!!
		
		if (key == KeyEvent.VK_W)
		{
			if (!p.isJumping())
			  {
				  p.jump();
			  }		
		}
		if (key == KeyEvent.VK_S) 
		{
			p.crouch();
		}							 	
		if (key == KeyEvent.VK_A)
		{
			if (p.getPosX() - p.getMoveLength() >= 0)
			  {
				  p.move("LEFT"); 	//CAN BE CONSTANT LATER 
			  }	
		}
		if (key == KeyEvent.VK_D)
		{
			if (p.getPosX() + p.getMoveLength() <= screenWidth)
			  {
				  p.move("RIGHT");  //CAN BE CONSTANT LATER
			  }	
		}	
	}
	
	public void setScreenWidth(int width)
	{
		screenWidth = width;
	}
}
