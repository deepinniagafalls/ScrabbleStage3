package code.base;

import java.util.ArrayList;
import java.util.Random;


public class Board_024 {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile_024[][] _board;
	private Tile_024 _tempTile;
	
	/**
	 * Stores all 400 individual letter multipliers on the board
	 */
	private int[] _letterMultipliers = new int[400];
	
	/**
	 * Stores all 400 whole word multipliers on the board
	 */
	private int[] _wordMultipliers = new int[400];
	
	private ArrayList<Integer> _letterIndexRepeats = new ArrayList<Integer>();
	
	private ArrayList<Integer> _wordIndexRepeats = new ArrayList<Integer>();
	
	/**
	 * Class constructor.
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
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void addTile(Tile_024 t, int x, int y){
		_board[x][y] = t;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile_024 removeTile(int x, int y){
		Tile_024 temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return
	 */
	public Tile_024 getTile(int x, int y){
		return _board[x][y];
	}

	public void setTempTile(Tile_024 t){
		_tempTile = t;
	}
	
	public Tile_024 getTempTile(){
		return _tempTile;
	}
	
	public int getLetterMultiplier(int index){
		return _letterMultipliers[index];
	}
	
	public int getWordMultiplier(int index){
		return _wordMultipliers[index];
	}
	
	public void setLetterMultiplier(int index){
		_letterMultipliers[index] = 1;
	}
	
	public void setWordMultipliers(int index){
		_wordMultipliers[index] = 1;
	}
}
