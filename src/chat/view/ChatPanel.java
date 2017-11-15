package chat.view;
import javax.swing.*;

import chat.controller.ChatbotController;


public class ChatPanel extends JPanel
{
	
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
	}
	

}
