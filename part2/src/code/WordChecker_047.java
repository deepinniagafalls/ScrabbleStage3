package code;


import java.util.ArrayList;

import javax.swing.JButton;

import code.base.Board_024;
import code.base.Tile_024;
import code.client.BoardFrame_047;
import code.client.PlayerFrame_047;
import code.util.ReaderTool_047;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(jaeheunk) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 * The WordChecker class is responsible for checking the validity of a word placed on the Board/BoardFrame by the player. Invalid words are incorrectly spelled.
 */
public class WordChecker_047 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to a new ReaderTool
	 */
	private ReaderTool_047 _r;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the coordinates of a row
	 */
	private ArrayList<Integer>	_rowCoordinates;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the coordinates of a column
	 */
	private ArrayList<Integer> _colCoordinates;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to an ArrayList of tiles placed
	 */
	private ArrayList<Tile_024> _tilesPlaced;
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
	 * Instance variable that holds reference to the Board class
	 */
	private Board_024 _b;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Instance variable that holds reference to the number of passes in a row
	 */
	private int _numberOfPassesInARow = 0;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Constructor for the WordChecker class that checks if a wrd is valid
	 * @param boardframe Holds Reference to the BoardFrame class
	 * @param board Holds reference to the Board class
	 */
	public WordChecker_047(BoardFrame_047 boardframe, Board_024 board, String path){
		_r = new ReaderTool_047(path);
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_bf = boardframe;
		_b = board;
		_tilesPlaced = new ArrayList<Tile_024>();
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that determines if a word is playable
	 */
	public String isThisWord(){
		if (isZero()){
			_numberOfPassesInARow = _numberOfPassesInARow + 1;
			if(_numberOfPassesInARow==_bf.getGame().getNumOfPlayers()){ //Terminates game
				_bf.getGame().printOutWinner();
				System.exit(0);
			}
			return null;
		}
		else{
		_numberOfPassesInARow = 0;
		String word = "";
		String wordForward = "";
		String wordBackward = "";
		boolean doesTheWordWrapAround = false;
		
		
		int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		
		//finds the first row and last row
		for(int i=1; i<_rowCoordinates.size();i++){
			if(firstRow>_rowCoordinates.get(i)){
				firstRow = _rowCoordinates.get(i);
			}
			if(lastRow<_rowCoordinates.get(i)){
				lastRow = _rowCoordinates.get(i);
			}
		}
		
		//Finds the first column and last column
		for(int i=1; i<_colCoordinates.size();i++){
			if(firstCol>_colCoordinates.get(i)){
				firstCol = _colCoordinates.get(i);
			}
			if(lastCol<_colCoordinates.get(i)){
				lastCol = _colCoordinates.get(i);
			}
		}
		
		
		boolean forward = true;
		//finds if word is horizontal or vertical
		int rowDifference = Math.abs(firstRow-lastRow);
		int colDifference = Math.abs(firstCol-lastCol);
		
		//vertical word
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
					wordForward = wordForward + _b.getTile(firstRow+i,firstCol).getChar();
					wordBackward = wordBackward + _b.getTile(firstRow+i,firstCol).getChar();
			}
			
			int k = 1;
			while(_b.getTile(firstRow-k,firstCol) != null){
					wordForward = _b.getTile(firstRow-k,firstCol).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(firstRow-k,firstCol).getChar();
				k = k + 1;
			}
			
			int j = 1;
			while(_b.getTile(lastRow+j,lastCol) != null){
				wordForward = _b.getTile(lastRow+j,lastCol).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(lastRow+j,lastCol).getChar();
				j = j + 1;
			}
			
		}
		//horizontal word
		else{
			for(int i=0; i<colDifference+1; i++){
					wordForward = wordForward + _b.getTile(firstRow,firstCol+i).getChar();
					wordBackward = wordBackward + _b.getTile(firstRow,firstCol+i).getChar();
			}
			
			int k = 1;
			while(_b.getTile(firstRow,firstCol-k) != null){
					wordForward = _b.getTile(firstRow,firstCol-k).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(firstRow,firstCol-k).getChar();
					k = k + 1;
			}
			
			int j = 1;
			while(_b.getTile(lastRow,lastCol+j) != null){
				wordForward = _b.getTile(lastRow,lastCol+j).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(lastRow,lastCol+j).getChar();
				j = j + 1;
			}
			
		}

		
		if(_r.isThisAWord(wordForward) || _r.isThisAWord(wordBackward)){
			//begin here
			//vertical word
			if(rowDifference >= colDifference){
				for(int i=0; i<rowDifference+1; i++){
						_bf.getTileSpace(firstRow+i, firstCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
				}
				
				int k = 1;
				while(_b.getTile(firstRow-k,firstCol) != null){
						_bf.getTileSpace(firstRow-k, firstCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
						k = k + 1;
				}
				
				int j = 1;
				while(_b.getTile(lastRow+j,lastCol) != null){
					_bf.getTileSpace(lastRow+j, lastCol).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
					j = j + 1;
				}
				
			}
			//horizontal word
			else{
				for(int i=0; i<colDifference+1; i++){
						_bf.getTileSpace(firstRow, firstCol+i).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
				}
				
				int k = 1;
				while(_b.getTile(firstRow,firstCol-k) != null){
						_bf.getTileSpace(firstRow, firstCol-k).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
						k = k + 1;
				}
				
				int j = 1;
				while(_b.getTile(lastRow,lastCol+j) != null){
					wordForward = _b.getTile(lastRow,lastCol+j).getChar() + wordForward;
					wordBackward = wordBackward + _b.getTile(lastRow,lastCol+j).getChar();
					_bf.getTileSpace(lastRow, lastCol+j).setBackground(_bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor());
					j = j + 1;
				}
				
			}
			
			//end here
			
			return wordForward;
		}
		else{
			
			PlayerFrame_047 current = _bf.getPlayerFrame(_bf.getGame().getCurrentTurn());
			int counter = 0;
			for(int i = 0; i < 12; i ++){
				if(current.getPlayerSpace(i).getTile() == null){
					current.getPlayerSpace(i).setCurrentTile(_tilesPlaced.get(counter));
					current.getPlayerSpace(i).setText(Character.toString(_tilesPlaced.get(counter).getChar()) + "," + _tilesPlaced.get(counter).getValue());
					counter = counter + 1;
				}
			}
			for(int i = 0; i < _rowCoordinates.size(); i ++){
				//Right here
				TileSpace_047 tileToReplaceMultipliers = _bf.getTileSpace(_rowCoordinates.get(i), _colCoordinates.get(i));
				int letterMultiplier = _b.getLetterMultiplier(_rowCoordinates.get(i)*20+_colCoordinates.get(i));
				int wordMultiplier = _b.getWordMultiplier(_rowCoordinates.get(i)*20+_colCoordinates.get(i));
				tileToReplaceMultipliers.setText(letterMultiplier + " " + wordMultiplier);
				_bf.getTileSpace(_rowCoordinates.get(i), _colCoordinates.get(i)).setBackground(new JButton().getBackground());
				_b.removeTile(_rowCoordinates.get(i), _colCoordinates.get(i));
			}
			return null;
		}
	}
		
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Boolean method that determins if a word is forward
	 * @return Returns true a word is playable forward
	 */
	public boolean isWordForward(){
		return true;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Boolean method that determins if a word is backwards
	 * @return Returns false a word is playable backwards
	 */
	public boolean isWordBackWard(){
		return false;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that adds letters to a specific coordinate
	 * @param row Holds reference t a specific row
	 * @param col Holds reference to a specific column
	 */
	public void addLetter(int row, int col){
		_rowCoordinates.add(row);
		_colCoordinates.add(col);
		_tilesPlaced.add(_b.getTile(row,col));
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that clears the space
	 */
	public void clear(){
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_tilesPlaced = new ArrayList<Tile_024>();
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(jaeheunk) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @date 2015-APRIL-10
	 * Method that returns if a row coordinate is zero
	 * @return A row coordinate that equals zero
	 */
	public boolean isZero(){
		return _rowCoordinates.size() == 0;
	}
	
	public ArrayList<Integer> getRowCoordinates(){
		return _rowCoordinates;
	}
	
	public ArrayList<Integer> getColCoordinates(){
		return _colCoordinates;
	}
	
	
}
