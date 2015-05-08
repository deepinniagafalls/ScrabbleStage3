package code;

import java.awt.FileDialog;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;


import code.base.Board_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.base.TileRack_024;
import code.base.Inventory_024;
import code.client.BoardFrame_047;
import code.client.PlayerFrame_047;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(jaeheunk) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MARCH-7
 * The SaveGame class is responsible for saving the current state of the game in a text file.
 */
@SuppressWarnings("unused")
public class SaveString {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to the TileRack class
	 */
	private TileRack_024 _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 ** @date 2015-MARCH-7
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds reference to a specidif file to write to
	 */
	private String _fileToWriteTo;
	
	//public static void main(String[] args) throws IOException{
		//SaveGame t = new SaveGame();
		//t.writeNewFile();
		
	//}
	
	private String _bw;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Constructor for the SaveGame class
	 * @param Reference to the Board class
	 * @param Reference to the BoardFrame class
	 * @param Reference to the Scrabble class
	 * @throws Throws IOException
	 */
	
	public SaveString(Board_024 b, BoardFrame_047 bf, Scrabble_024_047 s) throws IOException{
		_b = b;
		_bf = bf;	


			_scrabble = s;
			JFrame jf = new JFrame();
			FileDialog chooser = new FileDialog(jf,"Save your file",FileDialog.SAVE);
			//FileDialog chooser = new FileDialog(j,"Save your file",FileDialog.LOAD);
			chooser.setDirectory("C:\\");chooser.setFile("*.txt");chooser.setVisible(true);
			String filename = chooser.getFile();
			String path = chooser.getDirectory();
			System.out.println(path);
			String filetoWrite = path + filename;
			_fileToWriteTo = filetoWrite;
			
			File file = new File(_fileToWriteTo);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			//String bw = new String();
			
			String boardsize = "20 20";
			addToString(boardsize);
			addToString("\n");
			
			String content = "/part2/res/words.txt";
			addToString(content);
			addToString("\n");
			
			for(int i = 0; i <_scrabble.getNumofPlayers(); i = i + 1 ){
				Player_024_047 p = _scrabble.returnPlayer(i);
				
				addToString("[" + p.getName() + "," +p.getColor() + "," + p.getScore());
				addToString(",");
				addToString("[");
				for(int j = 0; j <12; j = j+1){
					addToString(Character.toString(p.getTileRack().getTile(j).getChar()));
				}
				addToString("]");
				addToString("]");
				if(i < _scrabble.getNumofPlayers()-1){
					addToString(";");
				}
			}
			
			addToString("\n");
			
			int turn = _scrabble.getGame().getCurrentTurn();
			addToString(Integer.toString(turn));
			addToString("\n");
			
			for(int i = 0; i < _scrabble.getInv().getSize(); i = i + 1 ){
				addToString("[" + _scrabble.getInv().getTile(i).getChar() + "]");
			}
			addToString("\n");
			
			for(int i = 0; i<20; i = i + 1){
				for(int j = 0; j<20; j = j +1){
					if(_scrabble.getBoard().getTile(i, j) == null){
						addToString("-");
					}
					else{
						_scrabble.getBoard().getTile(i, j).getChar();
						_scrabble.getBoard().getTile(i,j).getColor();
						addToString("[" + _scrabble.getBoard().getTile(i, j).getChar() +  ", " + _scrabble.getBoard().getTile(i, j).getColor() + "]");
					}
					
				}
			}
			//bw.close();
			System.out.println(_bw);
			
		}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 ** @date 2015-MARCH-7
	 * Method that writes to a file
	 */
	public void writeNewFile() throws IOException{
		
		
	}
	
	public void addToString(String newString){
		_bw = _bw + newString;
	}
	
}
