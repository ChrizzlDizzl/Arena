package Main;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Player extends Drawable{

	//STATS FOR PLAYER	
	private int hp = 3;
	private int moveLength;
	private boolean jumping; //SO PERSON CANT JUMP MORE THAN 1 TIME WHILE IN AIR
	
	
	public Player(int x, int y, int h, int w, Color c) {
		super(x, y, h, w, c);
		moveLength = 5; //FOR TESTING
		jumping = false;
	}
	
	/////////////MOVE METHODE
	public void move(String direction) //
	{
		if (direction == "LEFT")
		{
			posX -= moveLength;
		}
		if (direction == "RIGHT")
		{
			posX += moveLength;
		}
	}
	
	public void jump()
	{
		Jump jump = new Jump();
	}
	
	public void crouch ()
	{
		System.out.println ("DUCKEN");
	}
		
	public int getMoveLength ()
	{
		return moveLength;
	}	
	
	public boolean isJumping ()
	{
		return jumping;
	}
	
	//INNER CLASS WITH THREAD TO HANDLE JUMPING
	private class Jump 
	{
		public Jump ()
		{
			jumping = true;
			System.out.println ("SPRING");
			jumping = false;
		}
		
		
	}
}
