package Main;

import java.awt.Color;


public abstract class Event extends Drawable
{
	protected int speed;	//HOW FAST THE EVENT IS
	protected String direction;	//IN WHICH DIRECTION IT GOES
	
	public Event(int x, int y, int h, int w, Color c, int s, String dir) {
		super(x, y, h, w, c);
		speed = s;
		direction = dir;
	}
}