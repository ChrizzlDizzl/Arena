package Main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.Action;

public class Joystick extends Drawable{

	private Boolean isVisible;
	private int screenWidth;
	
	public Joystick(int x, int y, int h, int w, Color c, int sW) {
		super(x, y, h, w, c);
		screenWidth = sW;
		isVisible = false;
	}
	
	public Boolean isVisible ()
	{
		return isVisible;
	}
	
	public Action keyHappened (String key, Player p)
	{
		isVisible = true;
		//SHOULD CHANGE LOOK HERE!!!!!!!!!!!!!!
		
		switch(key)
		{
			case GamePanel.JUMP:
									  if (!p.isJumping())
									  {
										  p.jump();
									  }
									  
									  break;	
			case GamePanel.MOVE_DOWN:
									  p.crouch();
									  break;	
			case GamePanel.MOVE_LEFT:
									  if (p.getPosX() - p.getMoveLength() >= 0)
									  {
										  p.move(GamePanel.MOVE_LEFT);  
									  }									 
									  break;
			case GamePanel.MOVE_RIGHT:		
									  if (p.getPosX() + p.getMoveLength() <= screenWidth)
									  {
										  p.move(GamePanel.MOVE_RIGHT);
									  }									  
								      break;				
			default: return null;
		}	
		return null;		
	}
}
