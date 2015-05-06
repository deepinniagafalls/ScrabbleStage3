package code.base;

import java.awt.Color;

public class Tile_024 {

	/**
	 * Stores the character of the tile.
	 */
	private char _letter;
	/**
	 * Stores the point value of the tile.
	 */
	private int _pointValue;
	
	private Color _color;
	
	/**
	 * Class constructor.
	 * 
	 * @param j character of the tile
	 * @param i point value of the tile
	 */
	public Tile_024(char j, int i){
		_letter = j;
		_pointValue = i;
	}
	
	/**
	 * Gets the character value of the tile.
	 * 
	 * @return character value of the tile.
	 */
	public char getChar(){
		return _letter;
	}
	
	
	/**
	 * Gets the point value of the tile.
	 * 
	 * @return the point value of the tile.
	 */
	public int getValue(){
		return _pointValue;
	}
	
	public Color getColor(){return _color;}
	public void setColor(Color c){_color = c;}
}
