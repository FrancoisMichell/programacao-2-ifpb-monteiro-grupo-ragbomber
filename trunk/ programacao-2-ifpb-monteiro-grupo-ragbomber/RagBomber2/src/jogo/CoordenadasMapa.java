package jogo;

import java.util.ArrayList;

public class CoordenadasMapa {

	private ArrayList<Coordenada> coordenadasMapa;

	public CoordenadasMapa() {
		coordenadasMapa = posicoesMapa();
	
		
		
	}

	private  ArrayList<Coordenada> posicoesMapa() {
		int[] posicaoX = {0,40, 80, 120, 160, 200, 240, 280, 320,  360, 400, 440,
				480, 520, 560, 600, 640, 680};
		int[] posicaoY = {0,40, 80, 120, 160, 200, 240, 280, 320,  360, 400, 440,
				480, 520};
		
		ArrayList<Coordenada> coordenadas = new ArrayList<Coordenada>();
		
		for (int i = 0; i < posicaoX.length; i++) {
			for (int j = 0; j < posicaoY.length; j++) {
				Coordenada valores = new Coordenada();
				valores.setX(posicaoX[i]);
				valores.setY(posicaoY[j]);
				coordenadas.add(valores);
			}
		}
		removeBlocosPlayers(coordenadas);
		return coordenadas;
	}
	
	public Coordenada getCoordenada(int x, int y) throws CoordenadaInexistenteException {
		Coordenada coordenada = new Coordenada();
		coordenada.setX(x);
		coordenada.setY(y);
		if(getCoordenadasMapa().contains(coordenada)) {
			return coordenada;
		}
		throw new CoordenadaInexistenteException();
		
	}
	
	public void removerCoordenadas(int x, int y){
		Coordenada remocao = new Coordenada();
		remocao.setX(x);
		remocao.setY(y);
		coordenadasMapa.remove(remocao);
	}


	private void removeBlocosPlayers(ArrayList<Coordenada> coordenadas) {
		//Remoção dos blocos onde o PLAYER 1 IRÁ NASCER
		Coordenada valores = new Coordenada();
		valores.setX(40);
		valores.setY(40);
		coordenadas.remove(valores);
		valores.setX(40);
		valores.setY(80);
		coordenadas.remove(valores);
		valores.setX(80);
		valores.setY(40);
		coordenadas.remove(valores);
		
		//Remoção dos blocos onde o PLAYER 2 IRÁ NASCER
		valores.setX(680);
		valores.setY(480);
		coordenadas.remove(valores);
		valores.setX(680);
		valores.setY(520);
		coordenadas.remove(valores);
		valores.setX(640);
		valores.setY(520);
		coordenadas.remove(valores);
	}
	public ArrayList<Coordenada> getCoordenadasMapa() {
		return coordenadasMapa;
	}
	public void setCoordenadasMapa(ArrayList<Coordenada> coordenadasMapa) {
		this.coordenadasMapa = coordenadasMapa;
	}
	
	
}
