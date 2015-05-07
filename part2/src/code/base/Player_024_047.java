package code.base;

import java.awt.Color;
import java.util.Random;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * This class is responsible for gathering the data that a player is supposed to have
 */
public class Player_024_047 {

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that golds reference to the Score
	 */
	private int _score;
	
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to a TileRack
	 */
	private TileRack_024 _rack;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to a Color
	 */
	private Color _myColor;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to a Players name
	 */
	private String _myName;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param inv: Holds reference to the Inventory class
	 * @param name: Holds reference to a players name
	 * Constructor for the PLayer class
	 */
	public Player_024_047(Inventory_024 inv, String name){
		_score = 0;
		//_inv = inv;
		_rack = new TileRack_024(inv);
		Random random = new Random();
		float hue = random.nextFloat();
		float saturation = (random.nextFloat() * 1.0f) + 0.6f;
		float luminance = (random.nextFloat() * 1.1f) + 0.7f; 
		_myColor = Color.getHSBColor(hue, saturation, luminance);
		_myName = name;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a Players score
	 * @return Returns the score for a player
	 */
	public int getScore(){
		return _score;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a players TileRack
	 * @return Returns a players TileRack
	 */
	public TileRack_024 getTileRack(){
		return _rack;
	}

	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a Color
	 * @return Returns a players color
	 */
	public Color getColor(){
		return _myColor;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that adds the score that a players gets
	 * @return Returns a players Score
	 */
	public int addScore(int score, int i){
		_score = score;
		_score = _score + i;
		return _score;
	}
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Method that gets a players name
	 * @return Returns a players name
	 */
	public String getName(){
		return _myName;
	}
	
}
