package code.base;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import code.client.Game_047;

public class Scrabble_024_047 {
	

	
	/**
	 * Stores tiles.
	 */
	private Inventory_024 _inv;
	/**
	 * Stores players.
	 */
	private ArrayList<Player_024_047> _players = new ArrayList<Player_024_047>();
	/**
	 * tile board to be played on
	 */
	private Board_024 _board;
	/**
	 * Number of players
	 */
	private int _numberOfPlayers;
	
	private boolean _isVeryFirstTurn = true;
	
	private Game_047 _g;
	
	
	/**
	 * Class constructor
	 */
	public Scrabble_024_047(int numberOfPlayers, Game_047 g){
		_inv = new Inventory_024();
		_board = new Board_024();
		_numberOfPlayers = numberOfPlayers;
		_g = g;
		
		for(int i = 0; i < _numberOfPlayers; i++){
			addNewPlayer(i);
		}
		try{}
		catch(IllegalArgumentException e){
			JOptionPane.showMessageDialog(null, "The maximum number of players is four");
		}

	}
	
	/**
	 * Adds a new player to the game.
	 */
	private void addNewPlayer(int index){
		_players.add(new Player_024_047(_inv, _g.getName(index)));
	}
	public ArrayList<Player_024_047> getPlayers(){
		return _players;
	}
	public int getNumofPlayers(){
		return _numberOfPlayers;
	}
	public Board_024 getBoard(){
		return _board;
	}
	public Inventory_024 getInv(){
		return _inv;
	}
	public Player_024_047 returnPlayer(int playernumber){
		return _players.get(playernumber);
	}
	public boolean getIsVeryFirstTurn(){
		return _isVeryFirstTurn;
	}
	public void setIsVeryFirstTurn(boolean b){
		_isVeryFirstTurn = b;
	}
	public Game_047 getGame(){
		return _g;
	}
}
