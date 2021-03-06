/**
 * Main source to search word. Similar to Resource.
 * @see ResourceManager
 */

package edu.drexel.cs451.hangman;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordAccessor implements ProvidingWord {
	private final String DictionaryFile;
	private List<String> dictionary;
	
	
	public WordAccessor(String filename)
	{
		this.DictionaryFile = filename;
	}
	
	public void loadDictionary()
	{
	 // open the dictionary file and read dictionary into an ArrayList
		Scanner input;
		try {
			input = new Scanner(new File(DictionaryFile));
			dictionary = new ArrayList<String>();
			while (input.hasNext())
				dictionary.add(input.next().toLowerCase());
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public String getRandomWord()
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(dictionary.size());
		
		return dictionary.get(randomInt);
		
	}
	

}
