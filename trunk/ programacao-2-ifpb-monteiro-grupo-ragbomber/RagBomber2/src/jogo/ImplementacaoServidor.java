package jogo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementacaoServidor extends UnicastRemoteObject implements IFRagBomberServer {

	
	protected ImplementacaoServidor() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private IFClienteRmi clientermi;
	
	public void mensagemServidor(String mensagem) throws RemoteException {
		System.out.println(mensagem);
		
	}

	@Override
	public void gerarBlocosDestrutiveis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colocarBomba(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mexerY() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mexerX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gerarUpgrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ipCliente(String localhost) {
		 try { 
	            clientermi = (IFClienteRmi) Naming.lookup("rmi://" + localhost + ":1235/cliente"); 
	            synchronized (this) { 
	                this.notifyAll(); 
	            } 
	        } catch (RemoteException e) { 
	            e.printStackTrace(); 
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	    } 
		
	
	public IFClienteRmi getClienteRmi() { 
        return clientermi; 
    }

	@Override
	public void mensagemCliente(String mensagem) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	}


