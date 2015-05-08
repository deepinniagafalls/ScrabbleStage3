package code.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import code.base.Board_024;
import code.base.Player_024_047;
import code.client.Game_047;
import code.client.PlayerFrame_047;
import code.i.ClientI;
import code.i.ServerI;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MARCH-7
 * This class is responsible for getting the server to run and function
 */
public class ServerS implements ServerI, Runnable {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to the board class
	 */
	private Board_024 _board;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to the number of players in the game
	 */
	private static int _numberOfPlayers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance varaible that holds reference to an ArrayList of players
	 */
	private static ArrayList<Player_024_047> _playerList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to an ArrayList of player frames
	 */
	private static ArrayList<PlayerFrame_047> _playerFrameList;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance varaible that holds reference to the current turn
	 */
	private static int _currentTurn = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance varaible that holds reference to the current game
	 */
	private static Game_047 _currentGame;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance varaible that holds reference to an ArrayList of names
	 */
	private ArrayList<String> _names = new ArrayList<String>();
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to an ArrayList of the clients
	 */
	private ArrayList<ClientI> _observers;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Constructor for the Server class
	 */
	public ServerS(){ 
		System.out.println("server running!");
		_observers = new ArrayList<ClientI>();

		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * This mehtod is responsible for running the server
	 */
	@Override
	public void run() {
		System.out.print("Client Requested to check whether there is a connection between the client and the server");
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param c: Local variable that holds the clients
	 * This method is responsible for adding the clients to the server
	 */
	@Override
	public void addClientI(ClientI c) throws RemoteException {
		System.out.println("[SERVER] Adding client");
		_observers.add(c);
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param data: Local varaible that holds reference to a string of data
	 * This method is responsible for starting the server
	 */
	@Override
	public void start(String data) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param name: Local variable that holds a string of names
	 * This method is responsible for sending the names across the server
	 */
	@Override
	public void sendName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param data: Local variable that holds reference to a string of data
	 * This method is responsible for sending the data to the server when the pass button is clicked
	 */
	@Override
	public void passTurn(String data) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
		
	}


