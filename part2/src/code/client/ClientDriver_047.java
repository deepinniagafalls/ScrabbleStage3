package code.client;

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
		/*ArrayList<String> names = new ArrayList<String>();
		for (String s: args) {
			names.add(s);
		}
		if(names.size() > 4){
			System.out.println("Only Four People can Play at Once!");
			System.exit(0);
		}
		else if(names.size() == 0){
			System.out.println("At least one man should be playing!");
			System.exit(0);
		}
		ClientGUI gui = new ClientGUI(names); */
		Game_047 g = new Game_047("GUI", false, null, null, null);
	}
}
