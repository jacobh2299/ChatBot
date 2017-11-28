package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;
/**
 * The chatbot model including all the methods needed for talking back to the user
 * @author jhar3975
 *
 */
public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	/**
	 * builds chatbot calls helper methods
	 * @param username
	 */
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String[7];
		this.verbs = new String [10];
		this.followUps = new String[5];
		
		buildVerbs();
		buildTopics();
		buildFollowups();
		buildQuestions();
		buildShoppingList();
		buildMovieList();
		buildCuteAnimals();
	}
	/**
	 * Creates options for the chatbot to say
	 */
	private void buildVerbs()
	{
		verbs[0] = "Like";
		verbs[1] = "Don't Like";
		verbs[2] = "ambivalent about";
		verbs[3] = "am thinking about";
		verbs[4] = "am eating";
		verbs[5] = "am indesisive about";
		verbs[6] = "am riding";
		verbs[7] = "am pooping";
		verbs[8] = "am swimming in";
		verbs[9] = "am schwifty about";
	}
	/**
	 * Creates the options
	 */
	private void buildTopics()
	{
		topics[0] = "Apple Sauce";
		topics[1] = "One Punch Man";
		topics[2] = "Jimmy Glasscock";
		topics[3] = "Orange Sauce";
		topics[4] = "Grape Sauce";
		topics[5] = "Tomato Sauce";
		topics[6] = "Szechuan Sauce";
	}
	
	private void buildFollowups()
	{
		
	}
	/**
	 * Creates the movie lists that the chatbot can pull from
	 */
	private void buildMovieList()
	{
		Movie StarWars = new Movie(" Star Wars");
		Movie StarTrek = new Movie(" Star Trek");
		Movie Hobbit = new Movie(" Hobbit");
		Movie LordOfTheRings = new Movie(" Lord Of The Rings");
		Movie HungerGames = new Movie(" Hunger Games");
		movieList.add(HungerGames);
		movieList.add(StarTrek);
		movieList.add(Hobbit);
		movieList.add(LordOfTheRings);
		movieList.add(StarWars);
	}
	/**
	 * Builds the shopping list items
	 */
	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("apples");
		shoppingList.add("gross things");
	}
	/**
	 * Builds the animal list that the chat bot can talk about
	 */
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("otter");
		cuteAnimalMemes.add("floofer");
		cuteAnimalMemes.add("kittie");
		cuteAnimalMemes.add("pupper");
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name? ";
		questions[1] = "What is your last name? ";
		questions[2] = "What is your mom's name? ";
		questions[3] = "What is your dad's name? ";
		questions[4] = "What is your sister's name? ";
		questions[5] = "What is your pet's name? ";
		questions[6] = "What is your social security? ";
		questions[7] = "What is your annual net worth? ";
		questions[8] = "What is your credit card number? ";
		questions[9] = "What is your address? ";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponce = "";
		chatbotResponce += "You said:"+"\n"+input+"\n";
		chatbotResponce += buildChatBotResponce();
		
		return chatbotResponce;
	}
	
	public String buildChatBotResponce()

	{
		String response = "I ";
		int random = (int) (Math.random() *verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		
		response += " " +topics[random] + ".\n";
		
		random =(int) (Math.random() * questions.length);
		response += questions[random]+"\n";
		
		
		random=(int) (Math.random()*2);
		
		if(random%2==0)
		{
			random =(int) (Math.random()* movieList.size());
			response+=movieList.get(random).getTitle() + " is a great movie!";
		}
		int followup = (int)(Math.random()*5);
		switch(followup) {
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response +=followUps[4] + "\n";
			response +=followUps[3] + "\n";
			break;
		}
	
		return response;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
			if(input !=null && input.length()>2)
			{
				validLength = true;
			}
		
		return validLength;
	}
	
	public boolean htmlTagChecker(String input)
	{
		return false;
	}
	
	public boolean userNameChecker(String input)
	{
		if(input == null || input.length() == 0 || !input.substring(0,  1).equals("@"))
		{
			return false;
		}
			for(int i = 1; i<input.length(); i++)
			{
				if(input.substring(i, i+1).equals("@"))
				{
					return false;
				}
			}
			return true;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		for(String item: cuteAnimalMemes)
		{
			if(input != null && input.equalsIgnoreCase(item))
			{
				return true;
			}
		}
		return false;
		
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		for(String item: shoppingList)
		{
			if(shoppingList != null && shoppingItem.equalsIgnoreCase(item))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		if(title != null && title.length() > 3)
		{
			return true;
		}
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		if(genre != null && genre.length() > 4)
		{
			return true;
		}
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		
		if (exitString !=null && exitString.equalsIgnoreCase("quit") )
		{
			return true;
		}
		
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		if(sample.contains("asd")||sample.contains("sdf")||sample.contains("SDF")
		||sample.contains("dfg")||sample.contains("cvb")||sample.contains(",./")
		||sample.contains("kjh")||sample.contains("DFG")||sample.contains("CVB")
		||sample.contains("KJH"))
		{
			return true;
		}
		return false;
	}
	public String toString()
	{
		String str ="";
		return str;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		currentTime = LocalTime.now();
		return currentTime;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
