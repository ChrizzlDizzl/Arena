package Main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.*;

public class GamePanel extends JPanel
{
	private LinkedList <Drawable> stuffToPaint;	
	private Platform platform;
	
	public GamePanel (LinkedList drawables)
	{				               
        //SHOULD BE CHANGED LATER ////////////////////////////
        Joystick joystick = (Joystick)drawables.get(1);
		Player player = (Player)drawables.get(0);
		
		this.addKeyListener(new KeyAdapter ()
		{
			public void keyPressed (KeyEvent e)
			{
				joystick.keyHappened(e.getKeyCode(), player);                 
			}
		});                		
		stuffToPaint = drawables;
		this.setVisible(true);      
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		
                initImages();
		drawBackground(g);
		
		for(Drawable d : stuffToPaint)
		{
			//USED WHEN IMAGES AVAILABLE
			//g.drawImage(d.getImage(), (int)d.getPosX(), (int)d.getPosY(), 
			//			d.getWidth(), d.getHeight(), d.getColor(), null);
			g.setColor(d.getColor());
			g.fillRect(d.getPosX(), d.getPosY(), d.getWidth(), d.getHeight());                       
		}
		platform = new Platform (0, (int)(this.getHeight() * 0.66), this.getWidth(), 100, Color.WHITE);
		platform.draw(g);
	}
        public Rectangle getPlatformHitbox(){
          if(platform != null){  
            return platform.getRectangle();
          }
          return null;
        }
	
	private void drawBackground (Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect (0, 0, getWidth(), getHeight());
		
		/*BACKGROUND SHOULD BE A DRAWABLE TOO
		VAR NAMED bkgrnd
		g.drawImage(bkgrnd.getImage(), bkgrnd.getPosX(), bkgrnd.getPosY(),
				bkgrnd.getWidth(), bkgrnd.getHeight(), NULL); */
	}
	
	private void initImages () 
	{
		//ADDED LATER, LOADS BUFFERED IMAGE
		
	}

	
	private class Platform extends Drawable
	{
		private Rectangle plat;
		public Platform(int x, int y, int w, int h, Color c) {
			super(x, y, w, h, c);
			plat = new Rectangle (x, y, w, h);
		}
		
		public Rectangle getHitbox()
		{
			return plat;
		}
		
		public Boolean checkTouch(Rectangle r)
		{
			return(plat.intersects(r));
		}
		
		public void draw(Graphics g)
		{
			g.setColor(this.getColor());
			g.fillRect(posX, posY, width, height);
		}
	}
}