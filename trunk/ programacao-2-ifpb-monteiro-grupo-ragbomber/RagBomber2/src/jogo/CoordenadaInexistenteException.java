package jogo;

public class CoordenadaInexistenteException extends RuntimeException {

	public CoordenadaInexistenteException() {
		super("Coordenada n�o existe.");
	}
	
}
