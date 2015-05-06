package code;

import java.awt.Color;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

import code.base.Board_024;
import code.base.Inventory_024;
//import code.base.ServerCode_024;
import server.Tile_024;
import code.base.Board_024;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
import code.client.BoardFrame_047;
import code.client.Game_047;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 * LoadGame is responsible for restoring a previously saved game state.
 */
public class LoadGame_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Tile_024Rack class
	 */
	private Tile_024 _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Game_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the String reading files
	 */
	private String _fileToRead;
	
	private String[] _tokens;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the LoadGame class
	 * @param Reference to the Scrabble class
	 * @param Reference to the Board class
	 * @param Reference to the BoardFrame class
	 * @throws IOException
	 */
	public LoadGame_047() throws IOException{

	_scrabble = new Game_047("GUI",false,null,null,null);
	
	JFrame jf = new JFrame();
	FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.LOAD);
	chooser.setDirectory("C:\\"); chooser.setFile("*.txt");
	chooser.setVisible(true); String filename = chooser.getFile();
	String path = chooser.getDirectory(); 
	//System.out.println(path);
	String filetoRead = path + filename; _fileToRead = filetoRead;
	File file = new File(_fileToRead); FileReader fw = new FileReader(file.getAbsoluteFile());
	BufferedReader bw = new BufferedReader(fw);
	
	String s = (bw.readLine());
	String delims = "\r\n";
	_tokens = s.split(delims);
	
	for (int i = 0; i < _tokens.length; i++){
		
	    System.out.println(_tokens[i]);
	    System.out.print("....................");
	    
	}
	
	updatePlayers();
	updateBoard();
	
	
	}

public void updateBoard(){
	String [] Tile_024s = new String[400];
	String s = _tokens[5];
	int counter = 0;
	
	for(int i = 0; i <s.length(); i++){
		
		if(s.charAt(i)!= '-'){
			Tile_024s[counter] = s.substring(i, i+35);
			i = i+34;
			counter = counter + 1;
			}}
	
	//Board board;
	
	for(int row = 0; row < 20; row ++){
		for(int col = 0; col < 20; col ++){
			if(Tile_024s[(row*20)+col] == "-"){
				board.setTile_024(null,row,col);
			}
			else{
				char i = Tile_024s[(row*20)+col].charAt(1);
				if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
					board.setTile_024(new Tile_024(i,1),row,col);
				}
				else if(i == 'Y'){
					board.setTile_024(new Tile_024(i,2),row,col);
				}
				else{
					board.setTile_024(new Tile_024(i,5),row,col);}}}}}



public void updatePlayers(){
	String playerRep = _tokens[2];
	String [] playerList = playerRep.split(";");
	int numOfPlayers = playerList.length;
	//_scrabble = new ServerCode(numOfPlayers);
	for(int i = 0; i < numOfPlayers; i++){
		String[] info = playerList[i].split(",");
		_scrabble.getPlayer(i).setName(info[0]);
		
		String colorInputs = info[1].replace("java.awt.Color[", "");
		colorInputs = colorInputs.replace("r=", "");
		colorInputs = colorInputs.replace("b=", "");
		colorInputs = colorInputs.replace("g=", "");
		colorInputs = colorInputs.replace("]", "");
		
		String [] numbers = colorInputs.split(",");
		int red = Integer.parseInt(numbers[0]);
		int blue = Integer.parseInt(numbers[1]);
		int green = Integer.parseInt(numbers[2]);
				
		Color savedColor = new Color(red,blue,green);
		
		_scrabble.getPlayer(i).setColor(savedColor);
	}
}


public void updateInventory(){
	Inventory inv = _scrabble.getInventory();
	String inventoryData = _tokens[4];
	String allTile_024s = inventoryData.replace("[", "");
	allTile_024s = allTile_024s.replace("]", "");
	inv.resetTile_024Bag();
	for(int i = 0; i< allTile_024s.length();i++){
		
	}
	
}
/*
	String[] tokens = s.split(delims);
	
	for (int i = 0; i < tokens.length; i++){
		
	    System.out.println(tokens[i]);
	    System.out.print("....................");
	    
	}
	
	String Tile_024s = tokens[10];
	
	//System.out.println(Tile_024s);
	
	
	//Scrabble _scrabble = new Scrabble(1);
	Board board = _scrabble.getBoard();
	*/
	

}
