package chat.view;
import javax.swing.*;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
private ChatbotController appController;
private ChatPanel appPanel;
public ChatFrame(ChatbotController appController)
{
	super();
	this.appController = appController;
	appPanel = new ChatPanel(appController);

	
	setupFrame();
}
private void setupFrame()
{
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setContentPane(appPanel);
	this.setTitle("ChatBot");
	this.setSize(500,500);
	this.setVisible(true);
}
}
