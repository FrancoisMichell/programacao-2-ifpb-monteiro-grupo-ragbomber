package jogo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacaoCliente extends UnicastRemoteObject implements IFClienteRmi {

	protected ImplementacaoCliente() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void conectar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desconectar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagem(String msg) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acharServidor(ClienteRmi stub) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acharServidor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ipCliente(String ip) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mensagemClienteRmi(String mensagem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ClienteRmi() {
		// TODO Auto-generated method stub
		
	}
	
	

}
