package remoteobjects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.IRemota;

public class RemoteObject extends UnicastRemoteObject implements IRemota {

	private static final long serialVersionUID = 1L;

	public RemoteObject() throws RemoteException {
		super();
	}
}