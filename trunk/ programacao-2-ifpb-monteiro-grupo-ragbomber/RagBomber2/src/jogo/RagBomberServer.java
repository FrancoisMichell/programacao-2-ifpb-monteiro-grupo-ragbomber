package jogo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;


public class RagBomberServer extends UnicastRemoteObject implements IFRagBomberServer {
	
	//private Destrutiveis =  new ArrayList<BlocoDestrutivel>();
	
	

	protected RagBomberServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		
		RagBomberServer ragbomberserver = new RagBomberServer();
		Registry reg = LocateRegistry.createRegistry(1099);
		reg.rebind("RagBomber", ragbomberserver);
		
		System.err.println("Servidor Pronto ");	
	}	
	
	@Override
	public void colocarBomba(int x, int y) {
		
		
	}



	@Override
	public void mexerY() {
		
		
	}



	@Override
	public void mexerX() {
		
		
	}


	@Override
	public void gerarBlocosDestrutiveis() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gerarUpgrade() {
		// TODO Auto-generated method stub
		
	}
	
}

