package code;

import java.util.ArrayList;

import javax.swing.UIManager;

import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;

public class ClientGUI {
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

}
