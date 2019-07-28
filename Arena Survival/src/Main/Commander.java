package Main;


import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Commander 
{
        
	private final static int TIMER_DELAY = 4;  // 1 second to test
	private static Timer mainTimer = new Timer(TIMER_DELAY, new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			timerTick();
                       
		}
	});
	
	private static MainFrame mFrame; // maybe used later
	
	public static void main(String[] args)
	{
		
		mFrame = new MainFrame();   // to start it
                
                mainTimer.start();
	}
	
	private static void timerTick () 
	{
		mFrame.timerTick();
                
		// should later run the game and repaint								// from here
	}
	
	private class EventLoader //SHOULD LOAD ALL THE DATA FOR EVENTS LATER
	{
		InputStream inputStream;
		URL url = getClass().getResource("EventData.txt");
		File eventData = new File (url.getPath());
		
		public EventLoader()
		{

			
		}
	}
        
}