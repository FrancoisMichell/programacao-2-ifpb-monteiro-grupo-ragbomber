package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFRagBomberServer extends Remote {
	
	
	public void mensagemCliente(String mensagem) throws RemoteException;
	
	public void gerarBlocosDestrutiveis() throws RemoteException;

	public void colocarBomba(int x, int y) throws RemoteException;
	
	public void mexerY() throws RemoteException;

	public void mexerX() throws RemoteException;

	public void gerarUpgrade()throws RemoteException;

	public void ipCliente(String ip) throws RemoteException;

	public void mensagemServidor(String mensagem) throws RemoteException;

	public IFClienteRmi getClienteRmi() throws RemoteException;

	

	
	
	

}