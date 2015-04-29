package code.server;

import java.io.IOException;
import java.util.ArrayList;

public class ServerDriver {
	public static void main(String[] args) throws IOException {
		ArrayList<String> ag = new ArrayList<String>();
		for(String s : args){
			ag.add(s);
		}
		String host = ag.get(0);
		int port = Integer.parseInt(ag.get(1));
		
		}
	}

