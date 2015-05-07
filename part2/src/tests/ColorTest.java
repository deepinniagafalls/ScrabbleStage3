package tests;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.io.IOException;

import org.junit.Test;

import code.TileSpace_047;
import code.base.Tile_024;
import code.client.BoardFrame_047;
import code.client.Game_047;

public class ColorTest {
	
	private TileSpace_047 _ts;
	
	private BoardFrame_047 _bf;
	
	@Test
	public void checkColor() throws IOException {
		TileSpace_047 ts = new TileSpace_047(0, 0, null, null, 0, 0);
		Game_047 g = new Game_047(null, false, null, null, null);
		for(int i = 0; i<g.getNumOfPlayers(); i=i+1){
			Color expected = null;
			Color actual = g.getPlayer(i).getColor();
			assertTrue("The players color is" + actual, expected == actual);
		}
		


}

}
