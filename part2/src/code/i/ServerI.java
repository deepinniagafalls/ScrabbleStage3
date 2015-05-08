package code.i;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MARCH-7
 * This interface is responsible for getting the server to work
 */
public interface ServerI extends Remote {
	//this interface specifies all the methods that are to be called by a client to a server.
	// Client -> this -> Methods in Server
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * Instance variable that holds the server registry key
	 */
	public static final String SERVER_REGISTRY_KEY = "Player";
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param c: Local variable that holds the client interface
	 * This method is responsible for adding the client
	 */
	public void addClientI(ClientI c) throws RemoteException;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param data: Local variable that holds reference to a string of data
	 * This method is responsible for starting up that string
	 */
	public void start(String data) throws RemoteException;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param name: Local variable that holds reference to a string of names
	 * Thi method is responsible for sending names across the server
	 */
	public void sendName(String name) throws RemoteException;
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @date 2015-MARCH-7
	 * @param data: Local variable that holds reference to a string of data
	 * This method is responsible for passing a turn across the server
	 */
	public void passTurn(String data) throws RemoteException;


}
