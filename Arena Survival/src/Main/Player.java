package Main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Drawable{

	//STATS FOR PLAYER	
	private int hp = 3;
	private int moveLength;
	private boolean jumping; //SO PERSON CANT JUMP MORE THAN 1 TIME WHILE IN AIR
	private Rectangle hitbox;
	
	
	public Player(int x, int y, int h, int w, Color c) {
		super(x, y, h, w, c);
		moveLength = 10; //FOR TESTING
		jumping = false;
		hitbox = new Rectangle (x, y, w, h);
	}
	
	/////////////MOVE METHODE
	public void move(String direction) //
	{
		if (direction == "LEFT")
		{
			posX -= moveLength;
			System.out.println ("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "LEFT");
		}
		if (direction == "RIGHT")
		{
			posX += moveLength;
			System.out.println ("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "RIGHT");
		}
	}
	
	public void jump()
	{
		Jump jump = new Jump();
	}
	
	public void crouch ()
	{
		System.out.println ("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "CROUCH");
	}
		
	public int getMoveLength ()
	{
		return moveLength;
	}	
	
	public boolean isJumping ()
	{
		return jumping;
	}
	
	public Boolean checkTouch(Rectangle other)
	{
		return(hitbox.intersects(other));
	}
	
	//INNER CLASS WITH THREAD TO HANDLE JUMPING
	private class Jump 
	{
		public Jump ()
		{
			jumping = true;
			System.out.println ("MOVEMENTSYSTEM UEBERPRUEFUNG: " + "SPRING");
			jumping = false;
		}
		
		
	}
}
