package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.base.Board_024;
import code.base.Tile_024;

public class PlaceTilesTest {

	@Test
	public void checkWord() {
		Board_024 b = new Board_024();
		
		Tile_024 t = new Tile_024('R', 5);
		Tile_024 t1 = new Tile_024('U', 1);
		Tile_024 t2 = new Tile_024('N', 5);
		
		b.addTile(t,2,2);
		b.addTile(t1,2,3);
		b.addTile(t2,2,4);
		
		String expected = "RUN";
		String actual = (Character.toString(b.getTile(2,2).getChar()) + Character.toString(b.getTile(2,3).getChar())+ Character.toString(b.getTile(2,4).getChar()));

		assertTrue("The value of this word is" + actual, expected.equals(actual));
}
	
}
