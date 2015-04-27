package code.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.UIManager;

import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.i.ClientI;

public class ClientGUI implements Runnable, ClientI {
	// NOT FINISHED yet
	ArrayList<PlayerFrame_047> _playerFrameList;
	ArrayList<Player_024_047> _playerList;
	int _numberOfPlayers;
	
	public ClientGUI(ArrayList<String> pnames){
		_numberOfPlayers = pnames.size();
		this.startGUI();
	}
	public void startGUI(){

			Scrabble_024_047 scrabble = new Scrabble_024_047(_numberOfPlayers, null); // Fix this
			Inventory_024 invent = scrabble.getInv();
			Board_024 board = scrabble.getBoard();
			_playerList = scrabble.getPlayers();
			_playerFrameList = new ArrayList<PlayerFrame_047>();

	}
	@Override
	public void update() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
