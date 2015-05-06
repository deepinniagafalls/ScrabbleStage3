package code.server;

import java.rmi.RemoteException;
import java.util.ArrayList;

import code.base.Board_024;
import code.base.Player_024_047;
import code.client.Game_047;
import code.client.PlayerFrame_047;
import code.i.ClientI;
import code.i.ServerI;

public class ServerS implements ServerI, Runnable {
	private Board_024 _board;
	private static int _numberOfPlayers;
	private static ArrayList<Player_024_047> _playerList;
	private static ArrayList<PlayerFrame_047> _playerFrameList;
	private static int _currentTurn = 0;
	private static Game_047 _currentGame;
	private ArrayList<String> _names = new ArrayList<>();
	
	public ServerS(){ 
		System.out.println("...server running...");
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClientI(ClientI c) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(ArrayList<String> names) throws RemoteException {
		_names = names;
		
	}



}
