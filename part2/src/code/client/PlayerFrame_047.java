package code.client;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import code.PlayerSpace_047;
import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
import code.base.TileRack_024;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * The Player_frame class is the graphical representation of the TileRack class. It contains 12 PlayerSpaces.
 */
public class PlayerFrame_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024_047 _s;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Inventory class
	 */
    private Inventory_024 _inv;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheunk (Jason(Jaeheun) Kim)
     * @author mjszymko (Michael Szymkowski)
     * @author shokoors (Shokoor Syed)
     * @date 2015-MAY-7
     * Instance variable that holds reference to the ArrayList of type players
     */
    private ArrayList<Player_024_047> _players;
    /**
     * @author tylerdie (Tyler Dietrich)
     * @author ceelman (Chris Elman)
     * @author jaeheunk (Jason(Jaeheun) Kim)
     * @author mjszymko (Michael Szymkowski)
     * @author shokoors (Shokoor Syed)
     * @date 2015-MAY-7
     * Instance variable that holds reference to the Board class
     */
	private Board_024 _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the number of players in the game
	 */
	private int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the board of buttons
	 */
	private JButton[][] _boardOfButtons = new JButton[1][12];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the board of player spaces
	 */
	private PlayerSpace_047[][] _boardOfPlayerSpaces = new PlayerSpace_047[1][12];
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the TileRack class
	 */
	private TileRack_024 _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Player_frame class
	 */
	private PlayerFrame_047 _pf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Tile class
	 */
	private Tile_024 _tileTemp;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the PlayerScape class
	 */
	private PlayerSpace_047 _current;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the turn of the player
	 */
	private int _myTurnNumber;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the current state of the game
	 */
	private Game_047 _currentGame;
	
	private JFrame _frame;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the points that the players begins with
	 */
	private JLabel _points = new JLabel("Points: 0000");
	
	private PlayerSpace_047 _previousPlayerSpace;

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Constructor for the Player_frame class that holds parts of the GUI
	 * @param Reference to the Scrabble class
	 * @param Reference to the TileRack class
	 * @param Reference to the int index
	 * @param Reference to hte current game
	 * @param reference to the names of the players
	 */
	public PlayerFrame_047(Scrabble_024_047 s, TileRack_024 tr, int index, Game_047 currentGame, ArrayList<String> name){

        _tr = tr;
		_s = s;
		_pf = this;
		_board = s.getBoard();
		_myTurnNumber = index;
		_currentGame = currentGame;
		_players = _s.getPlayers(); //Just added
		_frame = new JFrame("Tile Rack");
		_frame.add(_points);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(1500, 103);
		GridLayout grid = new GridLayout(1, 0, 0, 0);
		_frame.setLayout(grid);
		int row = 0;
		
		for(int i=0; i<12; i++){
			PlayerSpace_047 temp = new PlayerSpace_047(_s,i,_pf,_currentGame); 
			_boardOfButtons[row][i] = temp;
			_boardOfPlayerSpaces[row][i] = temp;
			_frame.add(temp);
		}
		if(index == 0){_frame.setTitle(name.get(0) + "'s Tile Rack");}
		if(index == 1){_frame.setTitle(name.get(1) + "'s Tile Rack");}
		if(index == 2){_frame.setTitle(name.get(2) + "'s Tile Rack");}
		if(index == 3){_frame.setTitle(name.get(3) + "'s Tile Rack");}
		_frame.setVisible(true);
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that updates the class
	 */
	public void update(){
	//	_inv = _s.getInv();
	//	_board = _s.getBoard();
	//	_numberOfPlayers = _s.getNumofPlayers();
	//	_points.setText("Points: "+(_players.get(_myTurnNumber)).getScore());
		_points.setText("Points: "+(_players.get(_currentGame.getCurrentTurn())).getScore());
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that removes tiles from a players space
	 * @return Null
	 */
	public Tile_024 removeTileFromPlayerSpace(int index){
		return null;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that sets a tile to a temporary value
	 */
	public void setTempTile(Tile_024 t){
		_tileTemp = t;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets the content of the Board class
	 * @return The content of the Board class
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
	 * Method that gets the current space of where the player is playing
	 * @return Returns that space
	 */
	public PlayerSpace_047 getCurrentSpace(){
		return _current;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that sets the current player scape to some value
	 * @param Holds value to the current space
	 */
	public void setCurrent(PlayerSpace_047 current){
		_current = current;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a players space
	 * @param holds value to a certain int value
	 * @return Returns the players values for their board
	 */
	public PlayerSpace_047 getPlayerSpace(int index){
		return _boardOfPlayerSpaces[0][index];
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets the players turn number
	 * @return Returns the players turn number
	 */
	public int getMyTurnNumber(){
		return _myTurnNumber;
	}
	
	public void setPreviousPlayerSpace(PlayerSpace_047 temp){
		_previousPlayerSpace = temp;
	}
	
	public PlayerSpace_047 getPreviousPlayerSpace(){
		return _previousPlayerSpace;
	}
	
	public void setTitle(String name){
		_frame.setTitle(name + "'s Tile Rack");
	}
	
	public void setPoints(String points){
		_points.setText(points);
	}
}
