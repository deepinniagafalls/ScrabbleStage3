package code.base;

import java.awt.Color;

public class Tile_024 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private char _letter;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private int _pointValue;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	private Color _color;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	public Color getColor(){return _color;}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	public void setColor(Color c){_color = c;}
}
