package code.base;

import java.util.ArrayList;

import java.util.Random;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * This class is responsible for holding data on the Board
 */

public class Board_024 {

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds a 2D Array for Tile
	 */
	private Tile_024[][] _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Tile class
	 */
	private Tile_024 _tempTile;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable to an array of multipliers
	 */
	private int[] _letterMultipliers = new int[400];
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to an array of word multipliers
	 */
	private int[] _wordMultipliers = new int[400];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable for an ArrayList of Integers for index repeating
	 */
	private ArrayList<Integer> _letterIndexRepeats = new ArrayList<Integer>();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable to an ArrayList of Integers for word repeating
	 */
	private ArrayList<Integer> _wordIndexRepeats = new ArrayList<Integer>();
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Constructor for the Board class
	 */
	public Board_024(){
		Random rand = new Random();
		
		_board = new Tile_024[20][20];
		
		for(int i=0; i<60; i++){
			int temp = rand.nextInt(400);
			while(_letterIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_letterIndexRepeats.add(temp);
			_letterMultipliers[temp] = 2;
		}
		for(int i=0; i<40; i++){
			int temp = rand.nextInt(400);
			while(_letterIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_letterIndexRepeats.add(temp);
			_letterMultipliers[temp] = 3;
		}
		for(int i=0; i<300; i++){
			int temp = rand.nextInt(400);
			while(_letterIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_letterIndexRepeats.add(temp);
			_letterMultipliers[temp] = 1;
		}
		for(int i=0; i<40; i++){
			int temp = rand.nextInt(400);
			while(_wordIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_wordIndexRepeats.add(temp);
			_wordMultipliers[temp] = 2;
		}
		for(int i=0; i<20; i++){
			int temp = rand.nextInt(400);
			while(_wordIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_wordIndexRepeats.add(temp);
			_wordMultipliers[temp] = 3;
		}
		for(int i=0; i<340; i++){
			int temp = rand.nextInt(400);
			while(_wordIndexRepeats.contains(temp)){
				temp = rand.nextInt(400);
			}
			_wordIndexRepeats.add(temp);
			_wordMultipliers[temp] = 1;
		}
	}

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param t: Reference to the Tile class
	 * @param x: Reference to an int
	 * @param y: Reference to another int
	 * Method that is responsible for holding a x and y value to a 2D array
	 */
	public void addTile(Tile_024 t, int x, int y){
		_board[x][y] = t;
	}

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param x: Reference to an int
	 * @param y: Reference to another int
	 * Method that is responsible for being able to remove a tile from  a specific spot and setting that spot to null then a temp
	 * @return Returns a temp value
	 */
	public Tile_024 removeTile(int x, int y){
		Tile_024 temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param x: Reference to an int
	 * @param y: Reference to an int
	 * Method that returns the spot on the Board
	 * @return Returns a tile at a specific spot on the Board
	 */
	public Tile_024 getTile(int x, int y){
		return _board[x][y];
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param t: Reference to the Tile Test
	 * Method that sets a temporary reference
	 */
	public void setTempTile(Tile_024 t){
		_tempTile = t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that return the value of the variable
	 * @return Returns a temp tile
	 */
	public Tile_024 getTempTile(){
		return _tempTile;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param index: int variable that holds an index
	 * Method that returns the multipliers at a certain index
	 * @return Returns a letter multiplier at a certain spot on the board
	 */
	public int getLetterMultiplier(int index){
		return _letterMultipliers[index];
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param index: int variable that holds an index
	 * Method that returns the multipliers at a certain index
	 * @return Returns a word multiplier at a certain spot on the board
	 */
	public int getWordMultiplier(int index){
		return _wordMultipliers[index];
	}
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(Jaeheun) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @author shokoors (Shokoor Syed)
		 * @date 2015-MAY-7
		 * @param index: int variable that holds an index
		 * Method that returns what is set to the multipliers
		 */
	public void setLetterMultiplier(int index){
		_letterMultipliers[index] = 1;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param index: int variable that holds an index
	 * Method that returns what is set to the multipliers
	 */
	public void setWordMultipliers(int index){
		_wordMultipliers[index] = 1;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * This method is responsible for clearing the Board
	 */
	public void clearBoard(){
		for(int row= 0; row < 20; row++){
			for(int col = 0; col < 20; col++){
				_board[row][col] = null;
			}
		}
	}
}
