package jogo;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Explosao {

	private ArrayList<Fogo> fogos;
	private ArrayList<Fogo> fogosDireita;
	private ArrayList<Fogo> fogosEsquerda;
	private ArrayList<Fogo> fogosCima;
	private ArrayList<Fogo> fogosBaixo;
	
	private int x, y, rangeExplosao;

	public Explosao(int x, int y, int rangeExplosao) {
		this.x = x;
		this.y = y;
		this.rangeExplosao = rangeExplosao;
		fogos = new ArrayList<Fogo>();
		criarExplosao();
		Timer timer = new Timer();
		int tempoEmChamas = 1000;
		timer.schedule(new RemindTask(), tempoEmChamas);

	}

	public void criarExplosao() {
		fogos.addAll(gerarFogoDireita());
		fogos.addAll(gerarFogoEsquerda());
		fogos.addAll(gerarFogoCima());
		fogos.addAll(gerarFogoBaixo());
	}

	private class RemindTask extends TimerTask {
		public void run() {
			apagarFogos();
		}
	}

	private void apagarFogos() {
		fogos.clear();

	}
	
	public  ArrayList<Fogo> gerarFogoDireita() {
		int x = 0;
		fogosDireita = new ArrayList<Fogo>();
		for (int i = 0; i <= getRangeExplosao(); i++) {
			Fogo fogoDireita = new Fogo(getX() + x, getY());
			fogosDireita.add(fogoDireita);
			;
			x += 40;

		}
		return fogosDireita;
	}

	private  ArrayList<Fogo> gerarFogoCima() {
		int y = -40;
		fogosCima = new ArrayList<Fogo>();
		for (int i = 0; i < getRangeExplosao() ; i++) {
			Fogo fogoCima = new Fogo(getX(), getY() + y);
			fogosCima.add(fogoCima);
			y -= 40;
			
		}
		return fogosCima;
	}
	private ArrayList<Fogo> gerarFogoEsquerda() {
		int x = -40;
		fogosEsquerda = new ArrayList<Fogo>();
		for (int i = 0; i < getRangeExplosao(); i++) {
			Fogo fogoEsquerda = new Fogo(getX() + x, getY());
			fogosEsquerda.add(fogoEsquerda);
			x -= 40;

		}
		return fogosEsquerda;
	}


	private ArrayList<Fogo> gerarFogoBaixo() {
		int y = 40;
		fogosBaixo = new ArrayList<Fogo>();
		for (int i = 0; i < getRangeExplosao(); i++) {
			Fogo fogoBaixo = new Fogo(getX(), getY() + y);
			fogosBaixo.add(fogoBaixo);
			y += 40;

		}
		return fogosBaixo;
	}
	public void setFogosDireita(ArrayList<Fogo> fogosDireita) {
		this.fogosDireita = fogosDireita;
	}

	public void setFogosEsquerda(ArrayList<Fogo> fogosEsquerda) {
		this.fogosEsquerda = fogosEsquerda;
	}

	public void setFogosCima(ArrayList<Fogo> fogosCima) {
		this.fogosCima = fogosCima;
	}

	public void setFogosBaixo(ArrayList<Fogo> fogosBaixo) {
		this.fogosBaixo = fogosBaixo;
	}


	public ArrayList<Fogo> getFogos() {
		return fogos;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRangeExplosao() {
		return rangeExplosao;
	}
	public ArrayList<Fogo> getFogoDireita() {
		return fogosDireita;
	}

	public ArrayList<Fogo> getFogoEsquerda() {
		return fogosEsquerda;
	}

	public ArrayList<Fogo> getFogoCima() {
		return fogosCima;
	}

	public ArrayList<Fogo> getFogoBaixo() {
		return fogosBaixo;
	}


}
