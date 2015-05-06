package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code.base.Tile_024;


public class ScoreTest {
	
	@Test
	public void checkWord() {
		Tile_024 t = new Tile_024('R', 5);
		Tile_024 t1 = new Tile_024('U', 1);
		Tile_024 t2 = new Tile_024('N', 5);
		int numberOne = t.getValue();
		int numberTwo = t1.getValue();
		int numberThree = t2.getValue();
		int expected = 11;
		int actual = numberOne + numberTwo + numberThree;
		assertTrue("The value of this word is" + actual, expected == actual);
}
}
