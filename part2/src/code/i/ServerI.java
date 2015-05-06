package code.i;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ServerI extends Remote {
	//this interface specifies all the methods that are to be called by a client to a server.
	// Client -> this -> Methods in Server
	public void addClientI(ClientI c) throws RemoteException;
	public void start(String data) throws RemoteException;
	public void sendName(String name) throws RemoteException;


}
