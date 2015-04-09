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
	
	public String isThisWord(){
		String word = "";
		String wordForward = "";
		String wordBackward = "";
		boolean doesTheWordWrapAround = false;
		
		
		int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		//finds the first row
		for(int i=1; i<_rowCoordinates.size();i++){
			if(firstRow>_rowCoordinates.get(i)){
				firstRow = _rowCoordinates.get(i);
			}
			if(lastRow<_rowCoordinates.get(i)){
				lastRow = _rowCoordinates.get(i);
			}
		}
		
		//Finds the first column
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
			while(_b.getTile(firstRow+j,firstCol) != null){
				wordForward = _b.getTile(firstRow+j,firstCol).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(firstRow+j,firstCol).getChar();
				j = j + 1;
			}
			
		}
		
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
			while(_b.getTile(firstRow,firstCol+j) != null){
				wordForward = _b.getTile(firstRow,firstCol+j).getChar() + wordForward;
				wordBackward = wordBackward + _b.getTile(firstRow,firstCol+j).getChar();
				j = j + 1;
			}
			
		}
		System.out.println(wordForward);
		System.out.println(wordBackward);
		
		if(_r.isThisAWord(wordForward) || _r.isThisAWord(wordBackward)){
			return wordForward;
		}
		else{
			return null;
		}
		
		
		
		
		
		
		
		
		
		/*
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
				if(firstRow<lastRow){
					word = word + _b.getTile(firstRow+i,firstCol).getChar();
					forward = true;
				}
				else{
					word = word + _b.getTile(firstRow-i,firstCol).getChar();
					forward = false;
				}
				System.out.println(word);
			}
			
			int k = 1;
			if(_b.getTile(firstRow-k,firstCol) != null){
				if(forward == true){
					word = _b.getTile(firstRow-k,firstCol).getChar() + word;
				}
				else{
					word = word + _b.getTile(firstRow-k,firstCol).getChar();
				}
				//k = k + 1;
			}
			
			int j = 1;
			if(_b.getTile(firstRow+j,firstCol) != null){
				if(forward == true){
					word = _b.getTile(firstRow+j,firstCol).getChar() + word;
				}
				else{
					word = word + _b.getTile(firstRow+j,firstCol).getChar();
				}
				//j = j + 1;
			}
			
		}
		
		else{
			for(int i=0; i<colDifference+1; i++){
				if(firstCol<lastCol){
					word = word + _b.getTile(firstRow,firstCol+i).getChar();
				}
				else{
					word = word + _b.getTile(firstRow,firstCol-i).getChar();
				}
			}
			
		}
		System.out.println(word);
		return _r.isThisAWord(word);
		*/
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//My original implementation
		
	/*	int firstRow = _rowCoordinates.get(0);
		int lastRow = _rowCoordinates.get(_rowCoordinates.size()-1);
		int firstCol = _colCoordinates.get(0);
		int lastCol = _colCoordinates.get(_colCoordinates.size()-1);
		
		int rowDifference = Math.abs(firstRow-lastRow);
		int colDifference = Math.abs(firstCol-lastCol);
		
		if(rowDifference >= colDifference){
			for(int i=0; i<rowDifference+1; i++){
				if(firstRow<lastRow){
					word = word + _b.getTile(firstRow+i,firstCol).getChar();
				}
				else{
					word = word + _b.getTile(firstRow-i,firstCol).getChar();
				}
			}
		}
		else{
			for(int i=0; i<colDifference+1; i++){
				if(firstCol<lastCol){
					word = word + _b.getTile(firstRow,firstCol+i).getChar();
				}
				else{
					word = word + _b.getTile(firstRow,firstCol-i).getChar();
				}
			}
			
		}
		System.out.println(word);
		return _r.isThisAWord(word);  */
	}
	
	public boolean isWordForward(){
		return true;
	}
	
	public boolean isWordBackWard(){
		return false;
	}
	
	public void addLetter(int row, int col){
		_rowCoordinates.add(row);
		_colCoordinates.add(col);
	}
	
}
