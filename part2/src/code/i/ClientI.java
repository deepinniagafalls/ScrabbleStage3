package code.i;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * @author tylerdie (Tyler Dietrich)
 * @author ceelman (Chris Elman)
 * @author jaeheunk (Jason(Jaeheun) Kim)
 * @author mjszymko (Michael Szymkowski)
 * @author shokoors (Shokoor Syed)
 * @date 2015-MARCH-7
 * This interface is responsible for making the client funtion
 */
public interface ClientI extends Remote {
	//this interface specifies all the methods that are to be called by a server to a client.
	// Server -> this -> Methods in Client
	/**
	 * @author tylerdie (Tyler Dietrich)
	 * @author ceelman (Chris Elman)
	 * @author jaeheunk (Jason(Jaeheun) Kim)
	 * @author mjszymko (Michael Szymkowski)
	 * @author shokoors (Shokoor Syed)
	 * @param turn 
	 * @date 2015-MARCH-7
	 * @param s: Local variable that holds reference to the large string getting passed to the server
	 * This method constantly updates that large string
	 * @throws IOException 
	 */
	public void update(String s, String turn) throws RemoteException, IOException;


}
