package code.i;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientI extends Remote {
	//this interface specifies all the methods that are to be called by a server to a client.
	// Server -> this -> Methods in Client
	public void update() throws RemoteException;


}
