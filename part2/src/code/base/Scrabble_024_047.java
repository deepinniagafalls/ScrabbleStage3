package code.base;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import code.client.Game_047;

public class Scrabble_024_047 {
	

	
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
	private Inventory_024 _inv;
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
	private ArrayList<Player_024_047> _players = new ArrayList<Player_024_047>();
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
	private Board_024 _board;
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
	private int _numberOfPlayers;
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
	private boolean _isVeryFirstTurn = true;
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
	private Game_047 _g;
	
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
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private void addNewPlayer(int index){
		_players.add(new Player_024_047(_inv, _g.getName(index)));
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
	public ArrayList<Player_024_047> getPlayers(){
		return _players;
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
	public int getNumofPlayers(){
		return _numberOfPlayers;
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
	public Board_024 getBoard(){
		return _board;
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
	public Inventory_024 getInv(){
		return _inv;
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
	public Player_024_047 returnPlayer(int playernumber){
		return _players.get(playernumber);
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
	public boolean getIsVeryFirstTurn(){
		return _isVeryFirstTurn;
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
	public void setIsVeryFirstTurn(boolean b){
		_isVeryFirstTurn = b;
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
	public Game_047 getGame(){
		return _g;
	}
}
