package tests;

import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

import code.TileSpace_047;
import code.base.Tile_024;
import code.client.BoardFrame_047;

public class ColorTest {
	
	TileSpace_047 _ts;
	
	BoardFrame_047 _bf;
	
	@Test
	public void checkColor() {
		TileSpace_047 ts = new TileSpace_047(0, 0, null, null, 0, 0);
		Color tempColor = _bf.getScrabble().returnPlayer(_bf.getGame().getCurrentTurn()).getColor();
		Color expected = _ts.getTile().setColor(tempColor);
		Color actual = _ts.getColor();
		assertTrue("The color is" + actual, expected == actual);
}

}
