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
 * @param p: Holds reference to the ArrayList of players
 * Method that is responsible for showing who wins the game and when the game ends
 */

public class Board_024 {

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private Tile_024[][] _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private Tile_024 _tempTile;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private int[] _letterMultipliers = new int[400];
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private int[] _wordMultipliers = new int[400];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private ArrayList<Integer> _letterIndexRepeats = new ArrayList<Integer>();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private ArrayList<Integer> _wordIndexRepeats = new ArrayList<Integer>();
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
		 * @param p: Holds reference to the ArrayList of players
		 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	public void setWordMultipliers(int index){
		_wordMultipliers[index] = 1;
	}
}
