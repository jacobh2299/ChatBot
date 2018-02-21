package chat.view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatbotController;
/**
 * 
 * @author Jacob Harris
 * @version 21/11/17 1.2 
 */

public class ChatPanel extends JPanel
{
	
	private ChatbotController appController;
	private JButton chatButton;
	private JButton saveButton;
	private JButton searchButton;
	private JButton tweetButton;
	private JButton loadButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		
		
		//Initialize GUI data members
		chatButton = new JButton("chat");
		saveButton = new JButton("Save");
		tweetButton = new JButton("Tweet");
		loadButton = new JButton("Load");
		searchButton = new JButton("Search");
		inputField = new JTextField(25);
		infoLabel = new JLabel("Type to chat with the chatbot");
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("Check contents");
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListerners();

	}
	private void setupScrollPane()
	{
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		
	}
	
	private void setupPanel() 
	{
		this.setBackground(Color.WHITE);	
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tweetButton);
		this.add(searchButton);
		chatArea = new JTextArea(10,15);
		
		add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	private void setupListerners() 
	{
		chatButton.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent click)
			{
			String userText = inputField.getText();
			String displayText = appController.interactWithChatbot(userText);
			chatArea.append(displayText);
			inputField.setText("");	
			}
			});
		
		chatButton.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent click)
		{
		String userText = inputField.getText();
		String displayText = appController.useCheckers(userText);
		chatArea.append(displayText);
		inputField.setText("");	
		}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
			
		searchButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		
		
		
		
		
		
		
		
	}

	private void setupLayout() 
	{
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 30, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, inputField);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 0, SpringLayout.NORTH, inputField);
		appLayout.putConstraint(SpringLayout.SOUTH, inputField, -29, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatArea, 202, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatArea, -137, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, searchButton, -4, SpringLayout.NORTH, tweetButton);
		appLayout.putConstraint(SpringLayout.EAST, searchButton, -10, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, tweetButton, -5, SpringLayout.NORTH, saveButton);
		appLayout.putConstraint(SpringLayout.EAST, tweetButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 0, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, -4, SpringLayout.NORTH, loadButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, -6, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, infoLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, infoLabel, -6, SpringLayout.NORTH, inputField);
	

		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.useCheckers(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
	}
}
