package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFClienteRmi extends Remote {
	
	void conectar() throws RemoteException;
	
	
	void desconectar() throws RemoteException;
	
	public void mensagem(String msg) throws RemoteException;
	
	

}
