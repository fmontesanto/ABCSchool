package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javax.swing.JOptionPane;

import interfaces.IRemota;
import remoteobjects.RemoteObject;

public class Server {
	
	public Server(){
		inicializar();
	}

	private void inicializar() {

		try {
			IRemota or = new RemoteObject();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost/Abc", or);
			System.out.println("Servidor Iniciado");
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "Error de iniciaización del objeto remoto");
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "Error de publicación del objeto");
		}
	}
}
