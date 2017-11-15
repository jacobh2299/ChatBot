package chat.view;
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

	private void setupListerners() 
	{
		
		
	}

	private void setupLayout() 
	{
		
		
	}

	private void setupPanel() 
	{
		
		
	}
	
	
	
}
