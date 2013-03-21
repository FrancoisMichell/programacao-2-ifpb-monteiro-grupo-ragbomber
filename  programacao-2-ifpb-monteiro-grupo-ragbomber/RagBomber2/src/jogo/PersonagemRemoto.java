package jogo;

import java.rmi.RemoteException;

public class PersonagemRemoto extends Personagem {
	
	public PersonagemRemoto(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private IFRagBomberServer server;
	
	
	@Override
	public void colocarBomba() {
		try {
			server.colocarBomba(getX(), getY());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.colocarBomba();
	}
	
	@Override
	public void mexerX() {
		try {
			server.mexerX();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.mexerX();
	}
	
	@Override
	public void mexerY() {
		try {
			server.mexerY();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.mexerY();
	}

}
