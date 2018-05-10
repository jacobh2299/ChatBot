//package chat.model;
//
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//import chat.controller.ChatbotController;
//import chat.controller.IOController;
//import twitter4j.GeoLocation;
//import twitter4j.Paging;
//import twitter4j.Query;
//import twitter4j.QueryResult;
//import twitter4j.ResponseList;
//import twitter4j.Status;
//import twitter4j.Twitter;
//import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
//
//
//public class CTECTwitter 
//{
//	private ChatbotController appController;
//	private Twitter chatbotTwitter;
//	private List<Status> searchedTweets;
//	private List<String> tweetedWords;
//	private long totalWordCount;
//	private HashMap<String, Integer> wordsAndCount;
//	
//	public CTECTwitter(ChatbotController appController)
//	{
//		this.appController = appController;
//		this.chatbotTwitter = TwitterFactory.getSingleton();
//		this.searchedTweets = new ArrayList<Status>();
//		this.tweetedWords = new ArrayList<String>();
//		this.totalWordCount = 0;
//		this.wordsAndCount = new HashMap<String, Integer>();
//	}
//	
//	public String getMostCommonWord(String username)
//	{
//		String mostCommon = "";
//		
//		collectTweets(username);
//		turnStatusesToWords();
//		totalWordCount = tweetedWords.size();
//		String [] boring = createIgnoredWordArray();
//		trimTheBoringWords(boring);
//		removeBlanks();
//		generateWordCount();
//		
//		ArrayList<Map.Entry<String, Integer>> sorted = sortHashMap();
//		
//		String mostCommonWord = sorted.get(0).getKey();
//		int maxWord = 0;
//		
//		maxWord = sorted.get(0).getValue();
//		
//		mostCommon = "The most common word in "+username+" is "+searchedTweets.size() + " tweets is " +mostCommonWord 
//				+", and it was used " + maxWord + "times.\nThis is " + (DecimalFormat.getPercentInstance().format(((double) maxWord)/totalWordCount))
//				+ " of total words: " + totalWordCount +" and is " +
//				(DecimalFormat.getPercentInstance().format(((double) maxWord)/wordsAndCount.size())) + " of the unique words: " +wordsAndCount.size();
//		mostCommon += "\n\n" + sortedWords();
//		
//		return mostCommon;
//	}
//	
//	private void generateWordCount() 
//	{
//		for(String word : tweetedWords)
//		{
//			if(!wordsAndCount.containsKey(word.toLowerCase()))
//			{
//				wordsAndCount.put(word.toLowerCase(), 1);
//			}
//			else
//			{
//				wordsAndCount.replace(word.toLowerCase(), wordsAndCount.get(word.toLowerCase()) + 1);
//			}
//		}
//	}
//
//	private void removeBlanks() 
//	{
//		for(int i = tweetedWords.size() - 1; i >= 0; i-- )
//		{
//			if(tweetedWords.get(i).trim().length() == 0)
//			{
//				tweetedWords.remove(i);
//			}
//		}
//	}
//
//	private void trimTheBoringWords(String [] boringWords)
//	{
//		for(int i = tweetedWords.size() - 1; i >= 0; i--)
//		{
//			for(int j = 0; j < boringWords.length; j++)
//			{
//				if(tweetedWords.get(i).equals(boringWords[j]))
//				{
//					tweetedWords.remove(i);
//					j = boringWords.length;
//				}
//			}
//		}
//	}
//	
//	
//	public void sendTweet(String textToTweet)
//	{
//		try
//		{
//			chatbotTwitter.updateStatus(textToTweet + "@ChatbotCTEC");
//		}
//		catch(TwitterException tweetError)
//		{
//			appController.handleErrors(tweetError);
//		}
//		catch(Exception otherError)
//		{
//			appController.handleErrors(otherError);
//		}
//	}
//	
//	private void collectTweets(String username)
//	{
//		searchedTweets.clear();
//		tweetedWords.clear();
//		
//		Paging statusPage = new Paging(1,100);
//		int page = 1;
//		long lastID = Long.MAX_VALUE;
//		
//		while(page <= 10)
//		{
//			statusPage.setPage(page);
//			try
//			{
//				ResponseList<Status> listedTweets = chatbotTwitter.getUserTimeline(username, statusPage);
//				for(Status current : listedTweets)
//				{
//					if(current.getId() < lastID)
//					{
//					searchedTweets.add(current);
//					lastID = current.getId();
//					}
//				}
//			}
//			catch(TwitterException searchTweetError)
//			{
//				appController.handleErrors(searchTweetError);
//			}
//			page++;
//		}
//		
//	}
//	
//	private void turnStatusesToWords()
//	{
//		for(Status currentStatus : searchedTweets)
//		{
//			String tweetText = currentStatus.getText();
//			String [] tweetWords = tweetText.split(" ");
//			for(int index = 0; index < tweetWords.length; index++)
//			{
//				tweetedWords.add(removePunctuation(tweetWords[index]).trim());
//			}
//		}
//	}
//
//	private String removePunctuation(String currentString)
//	{
//		String punctuation = ".,'?!:;\"() {}^[]<>-";
//		
//		String scrubbedString = "";
//		for(int i = 0; i < currentString.length(); i++)
//		{
//			if(punctuation.indexOf(currentString.charAt(i)) == -1)
//			{
//				scrubbedString += currentString.charAt(i);
//			}
//		}
//		return scrubbedString;
//	}
//	
//	private String [] createIgnoredWordArray()
//	{
//		String [] boringWords;
//		String fileText = IOController.loadFromFile(appController, "commonWords.txt");
//		int wordCount = 0;
//		
//		Scanner wordScanner = new Scanner(fileText);
//		
//		while(wordScanner.hasNextLine())
//		{
//			wordScanner.nextLine();
//			wordCount++;
//		}
//		
//		boringWords = new String [wordCount];
//		wordScanner.close();
//		
//		wordScanner = new Scanner(this.getClass().getResourceAsStream("data/commonWords.txt"));
//		for(int i = 0;i<boringWords.length;i++)
//		{
//			boringWords[i] = wordScanner.nextLine();
//		}
//		
//		wordScanner.close();
//		return boringWords;
//	}
//	
//	private ArrayList<Map.Entry<String, Integer>> sortHashMap()
//	{
//		ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(wordsAndCount.entrySet());
//		entries.sort((entry1, entry2) -> entry2. getValue().compareTo(entry1.getValue()));
//		
//		return entries;
//	}
//	
//	private String sortedWords()
//	{
//		String allWords = "";
//		String [] words = (String []) wordsAndCount.keySet().toArray();
//		ArrayList<String> wordList = new ArrayList<String>(wordsAndCount.keySet());
//		for(int i = 0; i< wordsAndCount.size(); i++)
//		{
//			words[i] = wordList.get(i);
//		}
//		for(int i = 0; i < words.length - 1; i++)
//		{
//			int maxI = i;
//			
//			for(int inner = i + 1; i < words.length; inner++)
//			{
//				if(words[inner].compareTo(words[maxI]) > 0)
//				{
//					maxI = inner;
//				}
//			}
//			
//			String tempMax = words[maxI];
//			words[maxI] = words[i];
//			words[i] = tempMax;
//		}
//		
//		for(String word : words)
//		{
//			allWords += word + ", ";
//		}
//	 
//		return allWords;
//	
//	}
//	
//	public String analyzeTwitterForTopic(String topic)
//	{
//		double latitude;
//		double longitude;
//		String results = "";
//		searchedTweets.clear();
//		Query twitterQuery = new Query(topic);
//		int resultMax = 750;
//		long lastID = Long.MAX_VALUE;
//		twitterQuery.setGeoCode(new GeoLocation(latitude, longitude), radius, Query.MEASUREMENT);
//		ArrayList<Status> matchingTweets = new ArrayList<Status>();
//		while(searchedTweets.size() < resultMax)
//		{
//			try
//			{
//				QueryResult resultingTweets = chatbotTwitter.search(twitterQuery);
//			}
//			catch(TwitterException error)
//			{
//				appController.handleErrors(error);
//			}
//			
//			twitterQuery.setMaxId(lastID - 1);
//		}
//		results += "Talk about the search results";
//		results += "Find a tweet that will pass one of the checkers in chatbot";
//		
//		int randomTweet = (int) (Math.random() * matchingTweets.size());
//		results += matchingTweets.get(randomTweet);
//		
//		return results;
//	}
//	
//	
//	
//}
