package jogo;

public class BlocoDestrutivelRemoto extends BlocoDestrutivel{
	public BlocoDestrutivelRemoto(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	private IFRagBomberServer server;
	
	@Override
	public void gerarUpgrade() {
		server.gerarUpgrade();
		super.gerarUpgrade();
	}
}
