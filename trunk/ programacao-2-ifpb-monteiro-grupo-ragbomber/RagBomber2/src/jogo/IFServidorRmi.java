package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface IFServidorRmi extends Remote {
	

	void conectar() throws RemoteException;
	
	void criarJogo() throws RemoteException;

	void desconectar() throws RemoteException;
	
	void mexer() throws RemoteException;
	
	void colocarBomba() throws RemoteException;
	
	void upgrade() throws RemoteException;
	
	public void mensagem(String msg) throws RemoteException;
	
	

}
