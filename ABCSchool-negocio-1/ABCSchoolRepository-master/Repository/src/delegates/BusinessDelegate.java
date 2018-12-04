package delegates;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.naming.CommunicationException;

import interfaces.IRemota;

public class BusinessDelegate {
	
	private static BusinessDelegate instancia;
	private IRemota remota;
	
	public static BusinessDelegate getInstancia() throws CommunicationException{
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	private BusinessDelegate() throws CommunicationException {
		try {
			remota = (IRemota)Naming.lookup("rmi://localhost/Abc");
		} catch (MalformedURLException e) {
			throw new CommunicationException("La dirección del servidor es incorrecta");
		} catch (RemoteException e) {
			throw new CommunicationException("La conección con el servidor es incorrecta");
		} catch (NotBoundException e) {
			throw new CommunicationException("Error en el acceso al servidor");	
		}
	}
	
}
