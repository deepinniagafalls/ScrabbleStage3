package code.base;

import java.util.ArrayList;

public class TileRack_024 {
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
	private Inventory_024 _inv;
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
	private ArrayList<Tile_024> _rack;
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
	public TileRack_024(Inventory_024 inv){
		_inv = inv;
		_rack = new ArrayList<Tile_024>();
		fillRack();
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
	public void fillRack(){
		while (_rack.size() < 12){
			_rack.add(_inv.removeRandomTile());
		}
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
	public Tile_024 removeTile(int i){
		Tile_024 tileToRemove = _rack.get(i);
		_rack.remove(i);
		return tileToRemove;
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
	public int getSize() {
		return _rack.size();
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
	public Tile_024 getTile(int i){
		return _rack.get(i);
	}
}
