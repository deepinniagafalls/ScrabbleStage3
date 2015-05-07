package code.base;

import java.awt.Color;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * This class is responsible for holding all the Data for a tile in the Game
 */
public class Tile_024 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to a char value for a tile
	 */
	private char _letter;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to an int value for a point value for a tile
	 */
	private int _pointValue;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to a Color value
	 */
	private Color _color;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param j: char value
	 * @param i: int value
	 * Constructor for the Tile class
	 */
	public Tile_024(char j, int i){
		_letter = j;
		_pointValue = i;
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets the char value for a Tile
	 * @return Returns a specific letter
	 */
	public char getChar(){
		return _letter;
	}
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a specific point value for a tile
	 * @return Returns that point value
	 */
	public int getValue(){
		return _pointValue;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a color for the Tile
	 * @return Returns a color value
	 */
	public Color getColor(){return _color;}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that sets the color to a local variable
	 */
	public void setColor(Color c){_color = c;}
}
