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
import java.util.Scanner;

import javax.swing.JFrame;

import code.base.Board_024;
import code.base.Inventory_024;
//import code.base.ServerCode_024;

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
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the String reading files
	 */
	private String _fileToRead;
	
	private String[] _tokens = new String[6];
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
	public LoadGame_047(Scrabble_024_047 scrabble, Board_024 b, BoardFrame_047 bf) throws IOException{
	_b = b;
	_bf = bf;
	_scrabble = scrabble;
	
	JFrame jf = new JFrame();
	FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.LOAD);
	chooser.setDirectory("C:\\"); chooser.setFile("*.txt");
	chooser.setVisible(true); String filename = chooser.getFile();
	String path = chooser.getDirectory(); 
	//System.out.println(path);
	String filetoRead = path + filename; _fileToRead = filetoRead;
	File file = new File(_fileToRead); FileReader fw = new FileReader(file.getAbsoluteFile());
	BufferedReader bw = new BufferedReader(fw);

	
	 String fileName = filetoRead;

     // This will reference one line at a time
     String line = null;

     try {
         // FileReader reads text files in the default encoding.
         FileReader fileReader = 
             new FileReader(fileName);

         // Always wrap FileReader in BufferedReader.
         BufferedReader bufferedReader = 
             new BufferedReader(fileReader);

         int counter = 0;
         
         while((line = bufferedReader.readLine()) != null) {
             //System.out.println(line);
             _tokens[counter] = line;
             counter = counter + 1;
         }    

         // Always close files.
         bufferedReader.close();            
     }
     catch(FileNotFoundException ex) {
         System.out.println(
             "Unable to open file '" + 
             fileName + "'");                
     }
     catch(IOException ex) {
         System.out.println(
             "Error reading file '" 
             + fileName + "'");                   
         // Or we could just do this: 
         // ex.printStackTrace();
     }

	/*
	for (int i = 0; i < _tokens.length; i++){
		
	    System.out.println(_tokens[i]);
	    System.out.print("....................");
	    
	}
	*/
	
     
	updateBoard();
	updatePlayers();
	
	
	
	}

public void updateBoard(){
	String [] Tile_024s = new String[400];
	String s = _tokens[5];
	System.out.println(s);
	int counter = 0;
	
	for(int i = 0; i < s.length(); i++){
		
		if(s.charAt(i)!= '-'){
			Tile_024s[counter] = s.substring(i, i+38);
			i = i+37;
			counter = counter + 1;
			}
		
		else{
			Tile_024s[counter] = "-";
			counter = counter + 1;
		}
		
	}
	
	//Board board;
	
	for(int i = 0; i < Tile_024s.length; i++){
		//System.out.println(Tile_024s[i]);
	}
	
	for(int row = 0; row < 20; row ++){
		for(int col = 0; col < 20; col ++){
			if(Tile_024s[(row*20)+col] == "-"){
				_b.addTile(null,row,col);
			}
			else{
				//System.out.println(Tile_024s[(row*20)+col].charAt(1));
				System.out.print(row + "   " + col);
				char i = Tile_024s[(row*20)+col].charAt(1);
				String colorInputs = Tile_024s[(row*20)+col].substring(19,36);
				
				colorInputs = colorInputs.replace("r=", "");
				colorInputs = colorInputs.replace("b=", "");
				colorInputs = colorInputs.replace("g=", "");
				colorInputs = colorInputs.replace("]", "");
				
				String [] numbers = colorInputs.split(",");
				int red = Integer.parseInt(numbers[0]);
				int blue = Integer.parseInt(numbers[1]);
				System.out.println(numbers[2]);
				int green = Integer.parseInt(numbers[2]);
						
				Color savedColor = new Color(red,blue,green);
				
				if ((i == 'A')||(i == 'E')||(i == 'I')||(i == 'O')||(i =='U')){
					_b.addTile(new Tile_024(i,1),row,col);
					_bf.getTileSpace(row, col).setText(Character.toString(i));
					_bf.getTileSpace(row, col).setBackground(savedColor);
				}
				else if(i == 'Y'){
					_b.addTile(new Tile_024(i,2),row,col);
					_bf.getTileSpace(row, col).setText(Character.toString(i));
					_bf.getTileSpace(row, col).setBackground(savedColor);
				}
				else{
					_b.addTile(new Tile_024(i,5),row,col);
					_bf.getTileSpace(row, col).setText(Character.toString(i));
					_bf.getTileSpace(row, col).setBackground(savedColor);}}}}}




public void updatePlayers(){
	String playerRep = _tokens[2];
	String [] playerList = playerRep.split(";");
	for(int i = 0; i < playerList.length; i++){
		System.out.println(playerList[i]);
	}
	int numOfPlayers = playerList.length;
	//_scrabble = new ServerCode(numOfPlayers);
	for(int i = 0; i < numOfPlayers; i++){
		String[] info = playerList[i].split(",");
		for(int x = 0; x < info.length; x++){
			//System.out.println(info[x]);
		}
		System.out.println(info[0]);
		String newName = info[0].replace("[","");
		//System.out.println(info[0]);
		_scrabble.returnPlayer(i).setName(newName);
		_bf.getPlayerFrame(i).setTitle(newName);
		
		
		String colorInputs = info[1] + "," + info[2] + "," + info[3]; 
		colorInputs = colorInputs.replace("java.awt.Color[", "");
		colorInputs = colorInputs.replace("r=", "");
		colorInputs = colorInputs.replace("b=", "");
		colorInputs = colorInputs.replace("g=", "");
		colorInputs = colorInputs.replace("]", "");
		System.out.println(colorInputs);
		String [] numbers = colorInputs.split(",");
		int red = Integer.parseInt(numbers[0]);
		//System.out.println(numbers[1]);
		int blue = Integer.parseInt(numbers[1]);
		int green = Integer.parseInt(numbers[2]);
				
		Color savedColor = new Color(red,blue,green);
				
		String [] tiles = new String[12];
		System.out.println(info[5]);
		
		String tilesToGrab = info[5].replace("[","");
		tilesToGrab = tilesToGrab.replace("]","");
		_bf.getPlayerFrame(i).setPoints("Points: " + info[4]);
		
		//_scrabble.returnPlayer(i).setColor(savedColor);
		for(int k = 0; k<12; k++){
			_bf.getPlayerFrame(i).getPlayerSpace(k).setBackground(savedColor);
			_bf.getPlayerFrame(i).getPlayerSpace(k).setText(Character.toString(tilesToGrab.charAt(k)));
		}
	}
}


public void updateInventory(){
	Inventory_024 inv = _scrabble.getInv();
	String inventoryData = _tokens[4];
	String allTile_024s = inventoryData.replace("[", "");
	allTile_024s = allTile_024s.replace("]", "");
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
