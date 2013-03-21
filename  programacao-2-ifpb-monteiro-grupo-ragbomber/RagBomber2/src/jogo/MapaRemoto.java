package jogo;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class MapaRemoto extends Mapa {

	private IFRagBomberServer server;
	
	@Override
	public void gerarBlocosDestrutiveis() {
		try {
			server.gerarBlocosDestrutiveis();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.gerarBlocosDestrutiveis();
	}
	
	@Override
	public ArrayList<Upgrade> getUpgrades() {
		// TODO Auto-generated method stub
		return super.getUpgrades();
	}
	
	
}
