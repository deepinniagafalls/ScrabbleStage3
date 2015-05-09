package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Scrabble_024_047;
import code.base.Tile_024;
import code.client.Game_047;

public class InventoryTests {

	@Test
	public void checkWord() throws IOException {
		Game_047 g = new Game_047("GUI", false, null, null, 2, null);
		Scrabble_024_047 s = new Scrabble_024_047(2,g);
		Inventory_024 inv = s.getInv();
		
		for(int i = 0; i < 9; i++){
			inv.removeRandomTile();
		}
		
		
		int expected = 391;
		int actual = inv.getSize();

		assertTrue("The size of the inventory actually is " + actual, expected == (actual));
}
	
}
