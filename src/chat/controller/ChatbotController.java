package chat.controller;
import javax.swing.*;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;

public class ChatbotController {
	
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Jacob Harris");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	

	public void start() 
	{
		String responce = display.collectResponse("What do you want to talk about?");
//		while(chatbot.lengthChecker(responce) && !chatbot.quitChecker(responce))
//		{
//			responce = popupChat(responce);
//			responce = display.collectResponse(responce);
//		}
	}
	
	
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	

}
