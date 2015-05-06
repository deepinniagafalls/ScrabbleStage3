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
 * @date 2015-APRIL-10
 * The SaveGame class is responsible for saving the current state of the game in a text file.
 */
@SuppressWarnings("unused")
public class SaveGame_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the BoardFrame class
	 */
	private BoardFrame_047 _bf;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the TileRack class
	 */
	private TileRack_024 _tr;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the Scrabble class
	 */
	private Scrabble_024_047 _scrabble;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a specidif file to write to
	 */
	private String _fileToWriteTo;
	
	//public static void main(String[] args) throws IOException{
		//SaveGame t = new SaveGame();
		//t.writeNewFile();
		
	//}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the SaveGame class
	 * @param Reference to the Board class
	 * @param Reference to the BoardFrame class
	 * @param Reference to the Scrabble class
	 * @throws Throws IOException
	 */
	
	

	
	public SaveGame_047(Board_024 b, BoardFrame_047 bf, Scrabble_024_047 s) throws IOException{
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
			BufferedWriter bw = new BufferedWriter(fw);
			

			String boardsize = "20 20";
			bw.write(boardsize);
			bw.write("\r\n");
			
			String content = "/part2/res/words.txt";
			bw.write(content);
			bw.write("\r\n");
			
			for(int i = 0; i <_scrabble.getNumofPlayers(); i = i + 1 ){
				Player_024_047 p = _scrabble.returnPlayer(i);
				
				bw.write("[" + p.getName() + "," +p.getColor() + "," + p.getScore());
				bw.write(",");
				bw.write("[");
				for(int j = 0; j <12; j = j+1){
					bw.write(p.getTileRack().getTile(j).getChar());
				}
				bw.write("]");
				bw.write("]");
				if(i < _scrabble.getNumofPlayers()-1){
					bw.write(";");
				}
			}
			
			bw.write("\r\n");
			
			int turn = _scrabble.getGame().getCurrentTurn();
			bw.write(turn);
			bw.write("\r\n");
			
			for(int i = 0; i < _scrabble.getInv().getSize(); i = i + 1 ){
				bw.write("[" + _scrabble.getInv().getTile(i).getChar() + "]");
			}
			bw.write("\r\n");
			
			for(int i = 0; i<20; i = i + 1){
				for(int j = 0; j<20; j = j +1){
					if(_scrabble.getBoard().getTile(i, j) == null){
						bw.write("-");
					}
					else{
						_scrabble.getBoard().getTile(i, j).getChar();
						_scrabble.getBoard().getTile(i,j).getColor();
						bw.write("[" + _scrabble.getBoard().getTile(i, j).getChar() +  ", " + _scrabble.getBoard().getTile(i, j).getColor() + "]");
					}
					
				}
			}
			bw.close();
			System.out.println("Done");
			
		}
		
		
		/**
		 * @author tylerdie (Tyler Dietrich)
		 * @author ceelman (Chris Elman)
		 * @author jaeheunk (Jason(jaeheunk) Kim)
		 * @author mjszymko (Michael Szymkowski)
		 * @date 2015-APRIL-10
		 * Method that writes to a file
		 */

	
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that writes to a file
	 */
	public void writeNewFile() throws IOException{
		
		
	}
	
}
