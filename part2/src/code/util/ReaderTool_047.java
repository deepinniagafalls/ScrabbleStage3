package code.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MARCH-7
 * This class is responsible for going through a text file of data and reading each line so that it can be used
 */
public class ReaderTool_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to an ArrayList of words
	 */
	private ArrayList<String> _words;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param path: Local variable that holds the path of the file
	 * Constructor for the ReaderTool class
	 */
	public ReaderTool_047(String path){
	_words = new ArrayList<String>();
    String  _line = null;
    try{
       BufferedReader br = new BufferedReader(new FileReader("Documents/words.txt"));
       while ((_line = br.readLine()) != null) {
          _words.add(_line);
       }       
    }
    catch(Exception e){}
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * This method is responsible for getting the words from the ArrayList
	 * @return Return the words
	 */
	public ArrayList<String> getWords(){
		return _words;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param s: Local variable that holds reference to a string
	 * This method is responsible for validating if a word is a able to be used in a game
	 * @return Returns the word
	 */
	public boolean isThisAWord(String s){
		return _words.contains(s);
		
	}
}
