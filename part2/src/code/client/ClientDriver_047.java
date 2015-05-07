package code.client;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

import alphonce.client.ClientUI;
import alphonce.i.IServer;

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
		if (args.length != 2) {
			System.err.println("usage: ClientDriver <hostname> <portnumber>");
			System.exit(1);
		}
		String hostName = args[0];
		int portNumber = 50047;
		// Convert "50NNN" (a String) to 50NNN (an int)
		try {
			portNumber =  Integer.parseInt(args[1]);
		}
		// If format is improper for a number, exit.
		catch (NumberFormatException e) {
			System.err.println("[CLIENT] Port number must consist only of decimal digits '0' through '9'.");
			e.printStackTrace();
			System.exit(1);
		}

		ClientGUI gui = new ClientGUI(names); 
		Game_047 g = new Game_047("GUI", false, null, null, null);


		// If there is no security manager running, create one.
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		// Try to find the RMI registry running on the server's host
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry(hostName, portNumber);
			System.out.println("[CLIENT] Registry object created.");
		}
		// If connection cannot be made, exit.
		catch (RemoteException e) {
			System.err.println("[CLIENT] Cannot connect to registry.");
			e.printStackTrace();
			System.exit(1);
		}
		// Try to get reference to remote server object 
		IServer server = null;
		try {
			System.out.println("[CLIENT] Trying to retrieve remote server from registry.");
			server = (IServer) registry.lookup(IServer.SERVER_REGISTRY_KEY);
			System.out.println("[CLIENT] Received reference to remote server.");
		}
		
		catch (AccessException e) {
			System.err.println("[CLIENT] Cannot access server.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (RemoteException e) {
			System.err.println("[CLIENT] Problem contacting remote server.");
			e.printStackTrace();
			System.exit(1);
		}
		catch (NotBoundException e) {
			System.err.println("[CLIENT] Server not bound with name \""+IServer.SERVER_REGISTRY_KEY+"\"");
			e.printStackTrace();
			System.exit(1);
		}
		
		// Connection ready - start up the client!
		SwingUtilities.invokeLater(new Game_047(hostName, false, hostName, hostName, null));
	}  

	}
