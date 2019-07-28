package Main;

import java.awt.*;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.*;

public class MainFrame extends JFrame
{
	private CardLayout cLayout;
	private JPanel cPanel;
	private Dimension sizeFrame = new Dimension (640,480);  //NOT USED YET
	
	private LinkedList drawables;
	
        private CollisionManager collisions;
        
	private GamePanel gPanel;
	private MenuPanel mPanel;
	
	private String activeCardName; //STORES NAME OF ACTIVE CARD 
	private HashMap cards;			//STORES CARDS TO FIND OUT WHICH IS WHICH
	
	public static final String GAME_PANEL = "GAME_PANEL", MENU_PANEL = "MENU_PANEL", TEST ="test";
	
	public MainFrame ()
	{				
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //MAYBE LATER CONSTANT SIZE
		
		cLayout = new CardLayout(0, 0);	//init CardLayout
		cPanel = new JPanel (cLayout); //init CardLayoutPanel
		collisions = new CollisionManager();
		
		initDrawables();
			//init Panels
                
		mPanel = new MenuPanel(this);
                gPanel = new GamePanel(drawables);
						
		cards = new HashMap <String, JPanel> ();	//FOR SAVING ACTIVE
		cards.put(GAME_PANEL, gPanel);
		cards.put(MENU_PANEL, mPanel);
		
		cPanel.add(gPanel, GAME_PANEL);	//add Panels
		cPanel.add(mPanel, MENU_PANEL);
				
		cLayout.show(cPanel, MENU_PANEL); 
		activeCardName = MENU_PANEL;

		this.add(cPanel);	//add CardLayoutPanel to Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
                
                collisions.start();
	}
	
	public void changePanelTo (String panelName) 
	{
		if (!cards.containsKey(panelName))
		{
			return;
		}
		JPanel oldPanel = (JPanel)cards.get(activeCardName);
		oldPanel.setFocusable(false);
		
		JPanel newPanel = (JPanel)cards.get(panelName);
		newPanel.setFocusable(true);
		
		
		cLayout.show(cPanel, panelName);
		activeCardName = panelName;
                newPanel.requestFocus();
                
	}
        
	
	public void timerTick ()
	{
		Joystick tempJoystick = (Joystick)drawables.get(1);
		tempJoystick.setScreenWidth(this.getWidth());
		JPanel tempPanel = (JPanel) cards.get(activeCardName);
		tempPanel.repaint();
                
	}
	
	private void initDrawables () //CREATES DRAWABLES AND LOADS IMAGES
	{
		drawables = new LinkedList <Drawable>();
		
		Player player = new Player (900, 570, 100, 100, Color.GREEN);
		Joystick joystick = new Joystick (500, 500, 100, 100, Color.BLACK);
               
		
		drawables.add(0, player);	//TO FIND IT LATER
		drawables.add(1, joystick); //SO YOU CAN FIND IT LATER
		
		//EVENTS SHOULD BE ADDED TOO LATER
	}
	
	private class EventLoader //SHOULD LOAD ALL THE DATA FOR EVENTS LATER
	{
		public EventLoader()
		{

		}
	}
        
        private Rectangle getPlatformHB(){          
               return gPanel.getPlatformHitbox();
        }
        private Player getPlayer(){
               return (Player) drawables.get(0);
        }
        private class CollisionManager extends Thread{
            
            public void run() {
                if(getPlayer().checkTouch(getPlatformHB()) == true){ // Fehler weil vielleicht weil Player kein Player sondern Drawable ist?
                    getPlayer().fallDown();
                }
                int delay = 4;
                try {
                    Thread.sleep(delay);
                } catch (Exception e) {

                }
            }
        }
}