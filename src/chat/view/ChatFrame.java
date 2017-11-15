package chat.view;
import javax.swing.*;

import chat.controller.ChatbotController;

public class ChatFrame extends JFrame
{
private ChatbotController appController;
public ChatFrame(ChatbotController appController)
{
	super();
	this.appController = appController;
	
	setupFrame();
}
private void setupFrame()
{
	this.setVisible(true);
}
}
