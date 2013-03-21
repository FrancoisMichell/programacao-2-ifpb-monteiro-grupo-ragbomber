package jogo;

import java.rmi.RemoteException;

public class BlocoDestrutivelRemoto extends BlocoDestrutivel{
	
	public BlocoDestrutivelRemoto(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private IFRagBomberServer server;
	
	@Override
	public void gerarUpgrade() {
		try {
			server.gerarUpgrade();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.gerarUpgrade();
	}
}
