package code;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @date 2015-APRIL-10
 * Driver class with the main method that runs the game
 */

public class ClientDriver_047 {
	public static void main(String[] args) throws IOException {
		ArrayList<String> names = new ArrayList<String>();
		for (String s: args) {
			names.add(s);
		}
		if(names.size() > 4){
			System.out.println("Only Four People can Play at Once!");
			System.exit(0);
		}
		//Game_047 g = new Game_047("GUI", false);
	}
}
