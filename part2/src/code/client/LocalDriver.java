package code.client;

import java.io.IOException;

public class LocalDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostName = "host";
		try {
			new Game_047("GUI", false, null, null, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}