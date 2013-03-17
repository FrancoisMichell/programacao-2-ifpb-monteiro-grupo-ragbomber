package jogo;

import java.util.ArrayList;

public class MapaRemoto extends Mapa {

	private IFRagBomberServer server;
	
	@Override
	public void gerarBlocosDestrutiveis() {
		server.gerarBlocosDestrutiveis();
		super.gerarBlocosDestrutiveis();
	}
	
	@Override
	public ArrayList<Upgrade> getUpgrades() {
		// TODO Auto-generated method stub
		return super.getUpgrades();
	}
	
	
}
