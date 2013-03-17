package jogo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClienteRmi extends UnicastRemoteObject implements IFClienteRmi, Serializable {

	
	
	protected ClienteRmi() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void conectar() throws RemoteException {
		
		
	}

	@Override
	public void desconectar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
