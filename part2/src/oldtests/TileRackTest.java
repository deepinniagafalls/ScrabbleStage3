package oldtests;

import java.awt.Color;

import oldcode.Inventory;
import oldcode.Player;
import oldcode.Tile;
import oldcode.TileRack;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TileRackTest {

	// Test maximum capacity of 12 for tile rack
	@Test
	public void capacityTest(){
		Inventory inv = new Inventory();
		TileRack rack = new TileRack(inv, new Player(inv, 0, Color.BLUE));
		assertTrue("The tile rack should fill to a maximum size of 12 but I got " + rack.getSize(), rack.getSize() == 12);
	}

	// Test removing tiles
	@Test
	public void removeTest(){
		Inventory inv = new Inventory();
		TileRack rack = new TileRack(inv, new Player(inv, 0, Color.BLUE));
		Tile t = rack.removeTile(0);
		assertTrue("I removed one tile at index 0, now the rack size should be 11, but I got " + rack.getSize(), rack.getSize() == 11);
	}

	// Test adding tiles after removing tiles
	@Test
	public void addTest(){
		Inventory inv = new Inventory();
		TileRack rack = new TileRack(inv, new Player(inv, 0, Color.BLUE));
		rack.removeTile(0);
		rack.removeTile(1);
		rack.removeTile(2);
		rack.fillRack();
		assertTrue("I removed 3 tiles, then filled the rack, it's size should be 12, but I got " + rack.getSize(), rack.getSize() == 12);
	}



}