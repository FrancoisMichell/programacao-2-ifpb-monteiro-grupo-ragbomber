package jogo;

public class PersonagemRemoto extends Personagem {
	
	private IFRagBomberServer server;
	
	public PersonagemRemoto() {
	
	}
	
	
	@Override
	public void colocarBomba() {
		server.colocarBomba(getX(), getY());
		super.colocarBomba();
	}
	
	@Override
	public void mexerX() {
		server.mexerX();
		super.mexerX();
	}
	
	@Override
	public void mexerY() {
		server.mexerY();
		super.mexerY();
	}

}
