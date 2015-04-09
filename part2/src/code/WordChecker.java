package code;


import java.util.ArrayList;

import code.base.Board;
import code.util.ReaderTool;

public class WordChecker {
	
	private ReaderTool _r = new ReaderTool();
	private ArrayList<Integer>	_rowCoordinates;
	private ArrayList<Integer> _colCoordinates;
	private BoardFrame _bf;
	private Board _b;
	
	public WordChecker(BoardFrame boardframe, Board board){
		_rowCoordinates = new ArrayList<Integer>();
		_colCoordinates = new ArrayList<Integer>();
		_bf = boardframe;
		_b = board;
	}
	
	public boolean isThisWord(){
		String word = "";
		boolean doesTheWordWrapAround = false;
		
		
		
		
		
		
		
		
		
		
		
		int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		int rowDifference = Math.abs(firstRow-lastRow);
		int colDifference = Math.abs(firstCol-lastCol);
		
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
				word = word + _b.getTile(firstRow+i,firstCol).getChar();
			}
		}
		else{
			for(int i=0; i<colDifference+1; i++){
				word = word + _b.getTile(firstRow,firstCol+i).getChar();
			}
			
		}
		System.out.println(word);
		return _r.isThisAWord(word);
	}
	
	public void addLetter(int row, int col){
		_rowCoordinates.add(row);
		_colCoordinates.add(col);
	}

}
