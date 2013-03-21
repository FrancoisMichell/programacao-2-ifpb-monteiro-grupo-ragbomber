package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFClienteRmi extends Remote {
	
	void conectar() throws RemoteException;
	
	public void mensagemClienteRmi(String mensagem) throws RemoteException;
	
	void desconectar() throws RemoteException;
	
	public void mensagem(String msg) throws RemoteException;
	
	public void ipCliente(String ip) throws RemoteException; 

	void acharServidor(ClienteRmi stub) throws RemoteException;

	void ClienteRmi() throws RemoteException;
	
	

}
