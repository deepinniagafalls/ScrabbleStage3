package code.base;

import java.util.ArrayList;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MAY-7
 * This class is responsible for holding all of the information for the players TileRack
 */
public class TileRack_024 {
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to the Inventory class
	 */
	private Inventory_024 _inv;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * Instance variable that holds reference to an ArrayList of tiles in the TileRack
	 */
	private ArrayList<Tile_024> _rack;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MAY-7
	 * @param inv: Holds reference to the Inventory class
	 * Constructor for the TileRack class
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
	 * Method that fills the players TileRack after their turn is over
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
	 * @param i: int value for a certain index
	 * Method that removes a Tile from the TileRack
	 * @return Returns the tile to remove
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
	 * Method that gets the size of the TileRack
	 * @return Returns the size of the TileRack
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
	 * @param i: int value for a certain index
	 * Method that gets the tiles in the TileRack
	 * @return Returns the Tiles in the TileRack
	 */
	public Tile_024 getTile(int i){
		return _rack.get(i);
	}
}
