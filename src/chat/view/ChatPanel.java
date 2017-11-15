package chat.view;
import java.awt.Color;

import javax.swing.*;
import chat.controller.ChatbotController;


public class ChatPanel extends JPanel
{
	
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10,15);
		inputField = new JTextField(25);
		appLayout = new SpringLayout();
		
		
		
		setupPanel();
		setupLayout();
		setupListerners();

	}
	
	private void setupPanel() 
	{
		this.setBackground(Color.BLACK);	
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		
	}
	
	private void setupListerners() 
	{
		
		
	}

	private void setupLayout() 
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 30, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -29, SpringLayout.SOUTH, this);
		
	}

	
	
	
	
}
