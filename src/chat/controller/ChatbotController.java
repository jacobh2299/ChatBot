package chat.controller;
import javax.swing.*;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.PopupDisplay;
/**
 * 
 * @author Jacob Harris
 *This is a controller that creates all of the classes that run.
 */
public class ChatbotController {
	
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	/**
	 * creates the chatbot, display, and appframe
	 */
	public ChatbotController()
	{
		chatbot = new Chatbot("Jacob Harris");
		display = new PopupDisplay();
		appFrame = new ChatFrame(this);
	}
	
/**
 * crates the Start for the program and loads default
 */
	public void start() 
	{
		String responce = display.collectResponse("What do you want to talk about?");
//		while(chatbot.lengthChecker(responce) && !chatbot.quitChecker(responce))
//		{
//			responce = popupChat(responce);
//			responce = display.collectResponse(responce);
//		}
	}
	
	
/**
 * UNUSED
 * @param chat
 * @return
 */
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
	}
	
	public String useCheckers(String text)
	{
		String response = "";
		if(chatbot.contentChecker(text))
		{
			response += "this text matches the special content \n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response += "This text matches the special content \n";
		}
		return response;
	}
	
	
	
	
	

}
