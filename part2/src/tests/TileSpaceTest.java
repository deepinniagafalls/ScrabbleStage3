package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.TileSpace_047;
import code.base.Board_024;
import code.base.Inventory_024;
import code.base.Scrabble_024_047;
import code.base.TileRack_024;
import code.client.BoardFrame_047;
import code.client.Game_047;
import code.client.PlayerFrame_047;

public class TileSpaceTest {
	
	@Test
	public void test() {
		TileSpace_047 ts = new TileSpace_047(0, 0, null, null, 0, 0);
		
	}
	
	@Test 
	public void isAdjactentTest() throws IOException{
		int row=0;int colm1=0; int colm2 =0;
		
		Game_047 g = new Game_047("", true , "", "", row, null);
		Scrabble_024_047 s= new Scrabble_024_047(0, g);
		Inventory_024 i = new Inventory_024();
		Board_024 b = new Board_024();
		ArrayList<PlayerFrame_047> pf = new ArrayList<PlayerFrame_047>();
		BoardFrame_047 bf = new BoardFrame_047(s, b, i, pf, g, s, null);
		TileSpace_047 ts = new TileSpace_047(row, colm1, s, bf, 0, 0);
		b.getTile(row, colm1);
		b.getTile(row, colm2);
		boolean expected = true;
		boolean actual = ts.isAdjacent();
		assertTrue("The boolean we want is " + actual, actual == expected);
		
		
	}
	

}
