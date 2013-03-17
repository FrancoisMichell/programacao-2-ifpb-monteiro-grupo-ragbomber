package jogo;

import java.util.ArrayList;
import java.util.Collections;



public class Mapa {
	ArrayList<Parede> paredes;
	ArrayList<BlocoDestrutivel> destrutiveis;
	ArrayList<Integer> esqueleto;
	ArrayList<Upgrade> upgrades;
	CoordenadasMapa  coordenadasMapa;
	

	public Mapa() {

		upgrades = new ArrayList<Upgrade>();
		construirMapa();
		
		
	}

	private void construirMapa() {
				
		montarEsqueleto();
		gerarParedes();
		gerarBlocosDestrutiveis();
		
	}

	private void gerarParedes() {
		paredes = new ArrayList<Parede>();
		for (int i = 0; i < esqueleto.size() - 1; i += 2) {
			paredes.add(new Parede(esqueleto.get(i), esqueleto.get(i + 1)));
			
		}
	}

	private void montarEsqueleto() {
		coordenadasMapa = new CoordenadasMapa();
		esqueleto = new ArrayList<Integer>();
		String[] level = { "PPPPPPPPPPPPPPPPPPP",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
		"PPPPPPPPPPPPPPPPPPP" };
		int x = 0, y = 0;
		for (String coordenada : level) {
			for (Character coords : coordenada.toCharArray()) {
				String posicao = Character.toString(coords);
				if (posicao.equals("P")) {
					esqueleto.add(x);
					esqueleto.add(y);
					removerPosicoes(x, y);
				}
				if (posicao.equals("B")) {
					esqueleto.add(x);
					esqueleto.add(y);
					removerPosicoes(x, y);
					
				}
				x += 40;
			}
			y += 40;
			x = 0;
		}
	}

	private void removerPosicoes(int x, int y) {
		coordenadasMapa.removerCoordenadas(x, y);
	}
	public void gerarBlocosDestrutiveis(){
		int numeroDeBlocosDestru = 60;
		destrutiveis = new ArrayList<BlocoDestrutivel>();
		Collections.shuffle(coordenadasMapa.getCoordenadasMapa());
		for(int i = 0; i < numeroDeBlocosDestru ; i++){
			destrutiveis.add(new BlocoDestrutivel(coordenadasMapa.getCoordenadasMapa().get(i).getX(), coordenadasMapa.getCoordenadasMapa().get(i).getY()));		
		}
		
	}
	
	public ArrayList<Parede> getParedes() {
		return paredes;
	}

	public ArrayList<Integer> getEsqueleto() {
		return esqueleto;
	}
	public ArrayList<BlocoDestrutivel> getDestrutiveis() {
		return destrutiveis;
	}


	public ArrayList<Upgrade> getUpgrades() {
		return upgrades;
	}

}
