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
	public GamePanel (LinkedList drawables)
	{				
		//SHOULD BE CHANGED LATER ////////////////////////////
		
                Joystick joystick = (Joystick)drawables.get(1);
		Player player = (Player)drawables.get(0);
		
		this.addKeyListener(new KeyAdapter ()
		{
			public void keyReleased (KeyEvent e)
			{
				joystick.keyHappened(e.getKeyCode(), player);
                               
                                
			}
		});
				
		
		//requestFocusInWindow(); //DOESNT GET FOCUSED 
		///////////////////////////////////////////
		
		stuffToPaint = drawables;
		
		this.setVisible(true);
                this.setFocusable(true);
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
		
	}
	
	private void drawBackground (Graphics g)
	{
		g.setColor(Color.WHITE);
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
}
