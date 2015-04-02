package code.base;


public class Board {

	/**
	 * 2-D array of tiles to store tiles.
	 */
	private Tile[][] _board;

	/**
	 * Class constructor.
	 */
	public Board(){
		_board = new Tile[20][20];
	}

	/**
	 * Adds a tile to a position on the board.
	 * 
	 * @param t	the tile to be added
	 * @param x	the x-coordinate of the placement location
	 * @param y the y-coordinate of the placement location
	 */
	public void addTile(Tile t, int x, int y){
		_board[x][y] = t;
	}

	/**
	 * Removes a tile from a position on the board.
	 * 
	 * @param x the x-coordinate of the tile to be removed
	 * @param y the y-coordinate of the tile to be removed
	 * @return
	 */
	public Tile removeTile(int x, int y){
		Tile temp = _board[x][y];
		_board[x][y] = null;
		return temp;
	}

	/**
	 * Returns the tile at a position.
	 * 
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 * @return
	 */
	public Tile getTile(int x, int y){
		return _board[x][y];
	}

}
