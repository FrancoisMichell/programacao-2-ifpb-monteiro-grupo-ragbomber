package jogo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFRagBomberServer extends Remote {
	
	
	public void gerarBlocosDestrutiveis();

	public void colocarBomba(int x, int y);
	
	public void mexerY();

	public void mexerX();

	public void gerarUpgrade();

	

	
	
	

}
