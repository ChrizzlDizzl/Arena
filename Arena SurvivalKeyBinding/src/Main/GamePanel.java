package Main;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.*;

public class GamePanel extends JPanel
{
	private LinkedList <Drawable> stuffToPaint;	
	
	//ONLY FOR KEYBINDINGS - LATER REMOVED
	public static final String JUMP = "jump", MOVE_LEFT = "move left", 
			MOVE_DOWN = "move down", MOVE_RIGHT = "move right";
	/////////////////////////////
	
	public GamePanel (LinkedList drawables)
	{				
		//SHOULD BE CHANGED LATER ////////////////////////////
		Joystick joystick = (Joystick)drawables.get(1);
		Player player = (Player)drawables.get(0);
		
		this.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("W"), JUMP);
		this.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("A"), MOVE_LEFT);
		this.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("S"), MOVE_DOWN);
		this.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("D"), MOVE_RIGHT);
		
		this.getActionMap().put(JUMP, joystick.keyHappened(JUMP, player));
		this.getActionMap().put(MOVE_LEFT, joystick.keyHappened(MOVE_LEFT, player));
		this.getActionMap().put(MOVE_DOWN, joystick.keyHappened(MOVE_DOWN, player));
		this.getActionMap().put(MOVE_RIGHT, joystick.keyHappened(MOVE_RIGHT, player));
				
		requestFocusInWindow(); //DUNNO IF NEEDED
		///////////////////////////////////////////
		
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
