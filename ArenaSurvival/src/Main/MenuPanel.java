package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuPanel extends JPanel
{
	private LinkedList buttons = new LinkedList <JButton>(); //TO ADD BUTTONS
	private MainFrame mainFrame;
	
	Color background = new Color (0, 255, 153); //LATER CHANGED TO IMAGE
	
	
	public MenuPanel (MainFrame mFrame) 
	{
		mainFrame = mFrame;
		this.setBackground(background);
		
		initButtons();
		
		//NEEDS TO ADD BETTER LAYOUT LATER, ONLY FOR 1 BUTTON RN
		this.add((Component) buttons.getFirst());
		
		this.setVisible(true);
                this.setFocusable(false);
	}
	
	private void initButtons() //TO ADD BUTTONS TO LIST
	{
		JButton startButton = new JButton ("Start Game");	//INIT START GAME BUTTON
		startButton.setBackground(Color.BLACK);
		startButton.setBorderPainted(false);
		startButton.setForeground(Color.WHITE);
		startButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.changePanelTo(MainFrame.GAME_PANEL);		
			}
			
		});
		startButton.setVisible(true);
		
		buttons.add(startButton);	//ADD BUTTON TO LIST
		
	}
	
}
