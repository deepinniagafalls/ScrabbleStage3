package code.client;

import java.io.Console;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import code.SaveString;
import code.UpdateGUI_047;
import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
import code.i.ClientI;
import code.i.ServerI;
import code.util.ReaderTool_047;

import java.util.Scanner.*;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * Game class is responsible for instantiating all of the elements for the graphic user interface (GUI).
 */
public class Game_047 implements Runnable, ClientI {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Tile class
	 */
	Tile_024 _t;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the number of players
	 */
	private static int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Scrabble class
	 */
	private static ArrayList<Player_024_047> _playerList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the players in the game
	 */
	private static ArrayList<PlayerFrame_047> _playerFrameList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the PlayerFrame class
	 */
	private static int _currentTurn = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the current turn
	 */
	private static Game_047 _currentGame;
	private Scrabble_024_047 _scrabble;
	private Board_024 _board;
	private BoardFrame_047 _bf;
	

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Constructor for the Game class
	 * @param String for the player names
	 * @throws IOEception
	 */
	
	private ArrayList<String> _names = new ArrayList<>();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the server
	 */
	private ServerI _server;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param s: holds a string
	 * @param mode: holds RMI stuff
	 * @param hostName: Holds the hostname we use
	 * @param portNumber: Holds the portnumber we use
	 * @param sv: holds RMI stuff
	 * Constructor for the Game class
	 */
	public Game_047(String s, boolean mode, String name, String hostName, int portNumber, ServerI sv) throws IOException{
		   _server = sv;
		   ClientI me = null;
		   String e1 = "";
	       String e2 = "";
	       String e3 = "";
	       String e4 = "";
	       String p = "";
	       String path = "";
	       String st = JOptionPane.showInputDialog(null, "Are you starting the game? Type yes(1) or no(0)","START",JOptionPane.QUESTION_MESSAGE);	      
	       boolean start = false;
	       s = "GUI";
	       int state = Integer.parseInt(st);
	       System.out.println(state + "");
	       if(state == 1){start = true; mode = true;}
	       else{start = false; mode = false;}
	      // ArrayList<String> names = new ArrayList<>();
		_currentGame = this;
		if(mode){
		if(s == "CUI"){
			System.out.print("Please type in the path of the dictionary file. Press Enter instead to use the dictionary that is already provided with the code: ");
		       Scanner ps = new Scanner(System.in);
		       path = ps.nextLine();
		       Integer pl = path.length();
		       if(pl == 0){
		    	   path = "Documents/words.txt";
		       }
		System.out.print("How many players do you want? ");
	       Scanner scanIn = new Scanner(System.in);
	       p = scanIn.nextLine();
		if(p != null){_numberOfPlayers = Integer.parseInt(p);}
		else{JOptionPane.showMessageDialog(null, "Error! you choose to cancel","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
		if(_numberOfPlayers == 2){
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();


			_names.add(e1);
			_names.add(e2);

		}
		else if(_numberOfPlayers == 3){
			//String e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			//String e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			//String e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();
			System.out.print("Please enter player 3's name in: ");
			Scanner scanIn4 = new Scanner(System.in);
		    e3 = scanIn4.nextLine();
			_names.add(e1);
			_names.add(e2);
			_names.add(e3);
			
		}
		else if(_numberOfPlayers == 4){
			System.out.print("Please enter player 1's name in: ");
			Scanner scanIn2 = new Scanner(System.in);
		    e1 = scanIn2.nextLine();
			System.out.print("Please enter player 2's name in: ");
			Scanner scanIn3 = new Scanner(System.in);
		    e2 = scanIn3.nextLine();
			System.out.print("Please enter player 3's name in: ");
			Scanner scanIn4 = new Scanner(System.in);
		    e3 = scanIn4.nextLine();
			System.out.print("Please enter player 4's name in: ");
			Scanner scanIn5 = new Scanner(System.in);
		    e4 = scanIn5.nextLine();
			_names.add(e1);
			_names.add(e2);
			_names.add(e3);
			_names.add(e4);
			
		}
		}
		else if(s != "CUI"){
		path = JOptionPane.showInputDialog(null, "Please type in the path of the dictionary file. Type default instead to use the dictionary that is already provided with the code","PATH",JOptionPane.QUESTION_MESSAGE);
		
	       Integer pl = path.length();
	       if(pl == 0){
	    	   path = "Documents/words.txt";
	       }
		p = JOptionPane.showInputDialog(null, "How many players do you want?","Number of Players",JOptionPane.QUESTION_MESSAGE);
		if(p != null){_numberOfPlayers = Integer.parseInt(p);}
		else{JOptionPane.showMessageDialog(null, "Error! you choose to cancel","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers > 4){
		JOptionPane.showMessageDialog(null, "Error! The maximum number of players is 4","ERROR",JOptionPane.ERROR_MESSAGE);System.exit(0);}
		if(_numberOfPlayers < 2){
			JOptionPane.showMessageDialog(null, "Error! The minimum number of players is 2","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);}
		if(_numberOfPlayers == 2){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		}
		else if(_numberOfPlayers == 3){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		_names.add(e3);
		}
		else if(_numberOfPlayers == 4){
		e1 = JOptionPane.showInputDialog(null, "Please enter player 1's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e2 = JOptionPane.showInputDialog(null, "Please enter player 2's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e3 = JOptionPane.showInputDialog(null, "Please enter player 3's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		e4 = JOptionPane.showInputDialog(null, "Please enter player 4's name in","Number",JOptionPane.QUESTION_MESSAGE);;
		_names.add(e1);
		_names.add(e2);
		_names.add(e3);
		_names.add(e4);
		}
		}
		}
		else{
		_numberOfPlayers = 2;
		_names.add("Wait for");
		_names.add("Other Player to pass a turn");
		}
		Scrabble_024_047 scrabble = new Scrabble_024_047(_numberOfPlayers, this);
		Inventory_024 invent = scrabble.getInv();
		Board_024 board = scrabble.getBoard();
		_playerList = scrabble.getPlayers();
		_playerFrameList = new ArrayList<PlayerFrame_047>();
		for(int i = 0; i < _numberOfPlayers; i++){
			_playerFrameList.add(new PlayerFrame_047(scrabble, scrabble.returnPlayer(i).getTileRack(), i, _currentGame, _names));
		}
		String player = _numberOfPlayers + "";
		_server.start(player);
		BoardFrame_047 boardframe = new BoardFrame_047(scrabble, board , invent,_playerFrameList, _currentGame, scrabble, path);
		_scrabble = scrabble;
		_bf = boardframe;
		SaveString sunrise = new SaveString(board, _bf, _scrabble);
		Extravaganza_047 fc = new Extravaganza_047(scrabble, boardframe, this, _names, _playerFrameList, path, _server, sunrise);

		
		
		try {
			boolean retry = false;
			do {
				try {
					me = (ClientI) UnicastRemoteObject.exportObject(this,portNumber);
					retry = false;
				}
				catch (ExportException e) {
					if (hostName.equals("localhost")) {
						System.out.print("Port "+portNumber+" is unavailable, trying ");
						portNumber++;
						System.out.println(portNumber);
						retry = true;
					}
					else {
						System.out.print("Port "+portNumber+" is unavailable.");
						e.printStackTrace();
						System.exit(1);
					}
				}
			} while (retry);

		} catch (RemoteException e) {
			System.err.println("[CLIENT] Could not export self.");
			e.printStackTrace();
			System.exit(1);
		}
		try {
			_server.addClientI(me);
		} catch (RemoteException e) {
			System.err.println("[CLIENT] Could not register with remote server.");
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that controls the turns for the game
	 * @return returns the current turn in the game
	 */
	
	public int incrementTurn(){
		if(_currentTurn == _numberOfPlayers-1){
			_currentTurn = 0;
			return _currentTurn;
		}
		else{
			_currentTurn = _currentTurn + 1;
			return _currentTurn;
		}
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that obtains the contents of the Game class
	 * @return Returns the current game
	 */
	public Game_047 getGame(){
		return _currentGame;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that obtains the current turn
	 * @return Returns the current turn
	 */
	public int getCurrentTurn(){
		return  _currentTurn;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets the number of players in the game
	 * @return Returns the number of players
	 */
	public int getNumOfPlayers(){
		return _numberOfPlayers;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param index: int value for a specific index	
	 * Method that gets a players name
	 * @return Returns a players name
	 */
	public String getName(int index){
		return _names.get(index);
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param index: int value for a specific index
	 * Method that gets a specific player
	 * @return Returns a specific player
	 */
	public Player_024_047 getPlayer(int index){
		return _playerList.get(index);
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets the list of players
	 * @return Returns that list
	 */
	public ArrayList<Player_024_047> getPlayerList(){
		return _playerList;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that prints out the winner of the game
	 */
	public void printOutWinner(){
		String winner = _playerList.get(0).getName();
		int highest = _playerList.get(0).getScore();
		for(int i=0; i<_numberOfPlayers; i++){
			if(_playerList.get(i).getScore()<highest){
				winner = _playerList.get(i).getName();
				highest = _playerList.get(i).getScore();
			}
		}
		System.out.println("The game is over, " + winner + " is the winner!");
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(String s, String turn) throws RemoteException,
			IOException {
		System.out.println(s);
		UpdateGUI_047 update = new UpdateGUI_047(_scrabble, _board, _bf, s);
		for(int i = 0; i < _scrabble.getNumofPlayers(); i++){
			_playerFrameList.get(i).setVisible(false);
		if(turn == null){
				_playerFrameList.get(i).setVisible(false);
		}
		else{
			_playerFrameList.get(i).setVisible(true);
		}
	}
	}
}
