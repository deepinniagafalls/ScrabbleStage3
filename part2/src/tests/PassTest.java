package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import code.base.Inventory_024;
import code.base.Player_024_047;
import code.base.Scrabble_024_047;
import code.client.Game_047;

public class PassTest {

	@Test
	public void passTest() throws IOException{
		Game_047 g = new Game_047("", false, "Mike", "styx", 0, null);
		Scrabble_024_047 s = new Scrabble_024_047(0, null);
		ArrayList<Player_024_047> p = new ArrayList<Player_024_047>();
		Inventory_024 i = new Inventory_024();
		Player_024_047 p1 = new Player_024_047(i, "Tyler");
		Player_024_047 p2 = new Player_024_047(i, "Mike");
		Player_024_047 p3 = new Player_024_047(i, "Chris");
		p.add(0, p1);
		p.add(1, p2);
		p.add(2, p3);
		g.getPlayer(0);
		g.getCurrentTurn();
		g.incrementTurn();
		Player_024_047 expected = p.set(1, p2);
		Player_024_047 actual = g.getPlayer(1);
		assertTrue("The current turn should be" + actual, expected.equals(actual));
	}
}
