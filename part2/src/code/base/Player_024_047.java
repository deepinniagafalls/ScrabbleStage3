package code.base;

import java.awt.Color;
import java.util.Random;


public class Player_024_047 {

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
	private int _score;
	
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
	private TileRack_024 _rack;
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
	private Color _myColor;
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
	private String _myName;
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
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
	 * @param p: Holds reference to the ArrayList of players
	 * Method that is responsible for showing who wins the game and when the game ends
	 */
	public String getName(){
		return _myName;
	}
	
}
