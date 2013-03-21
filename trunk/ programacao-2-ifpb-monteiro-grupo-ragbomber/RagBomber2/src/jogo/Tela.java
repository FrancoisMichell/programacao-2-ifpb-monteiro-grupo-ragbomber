package jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Tela extends JPanel implements ActionListener {

	private Personagem player1;
	private Personagem player2;
	private Image fundo;
	private Image vitoriaPlayer1;
	private Image vitoriaPlayer2;
	private Image empate;
	private Timer timer;
	private Mapa mapa;

	Sprites vilao = new Sprites(3, 100, 100);

	private boolean emJogo;

	public void atualizar() {
	}

	public Tela() {

		setDoubleBuffered(true);
		setFocusable(true);

		addKeyListener(new TecladoAdapter());

		ImageIcon telaFundo = new ImageIcon("Imagens\\_fundo.jpg");
		fundo = telaFundo.getImage();
		ImageIcon vitoriaPlayer1Tela = new ImageIcon("Imagens\\_1P_ganhou.jpg");
		vitoriaPlayer1 = vitoriaPlayer1Tela.getImage();
		ImageIcon vitoriaPlayer2Tela = new ImageIcon("Imagens\\_2P_ganhou.jpg");
		vitoriaPlayer2 = vitoriaPlayer2Tela.getImage();
		ImageIcon empateTela = new ImageIcon("Imagens\\_Empate.jpg");
		empate = empateTela.getImage();
		
		
		mapa = new Mapa();
		player1 = new Personagem(40, 40);
		player2 = new Personagem(680, 520);

		emJogo = true;

		timer = new Timer(15, this);
		timer.start();
	}

	public void paint(Graphics g) {

		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);

		if (emJogo) {
			graficos.drawImage(player1.getImagem(), player1.getX(),
					player1.getY(), this);
			graficos.drawImage(player2.getImagem2(), player2.getX(), player2.getY(), this);
			gerarBlocosParede(graficos);
			gerarBlocosDestrutiveis(graficos);
			gerarUpgrade(graficos);
			gerarBombasEExplosoes(graficos, player2);
			gerarBombasEExplosoes(graficos, player1);
			verificarMorte(graficos);
			
		}
		if(player1.getVida() == 0){
			graficos.drawImage(vitoriaPlayer2, 0, 0, null);
			
		}
		if(player2.getVida() == 0){
			graficos.drawImage(vitoriaPlayer1, 0, 0, null);
		
			
		}
		if(player1.getVida() == 0 & player2.getVida() == 0){
			graficos.drawImage(empate, 0, 0, null);
		
		}
		
	}

	private void verificarMorte(Graphics2D graficos) {
		if(player1.getVida() == 0){
			emJogo = false;
		}
		if(player2.getVida() == 0){
			emJogo = false;
		}	
	}

	private void gerarUpgrade(Graphics2D graficos) {
		for(int i = 0 ; i < mapa.getUpgrades().size() ; i++){
			Upgrade upgrade = mapa.getUpgrades().get(i);
			if(upgrade != null) {
				graficos.drawImage(upgrade.getUpgradeImagem(), upgrade.getX(), upgrade.getY(), this);
				pegarUpgrade(player1);
				pegarUpgrade(player2);
			}
		}
	}

	private void gerarBlocosParede(Graphics2D graficos) {
		for (int i = 0; i < mapa.getParedes().size(); i++) {
			Parede parede = mapa.getParedes().get(i);
			graficos.drawImage(parede.getParedeImagem(), parede.getPosicaoX(),
					parede.getPosicaoY(), this);
		}
	}

	private void gerarBlocosDestrutiveis(Graphics2D graficos) {
		for (int i = 0; i < mapa.getDestrutiveis().size(); i++) {
			BlocoDestrutivel bloco = mapa.getDestrutiveis().get(i);
			graficos.drawImage(bloco.getBlocoImagem(), bloco.getX(),
					bloco.getY(), this);
		}
	}

	private void gerarBombasEExplosoes(Graphics2D graficos, Personagem player) {
		/*
		 * Gera a imagem das bombas e logo após a da explosao
		 */
		for (int i = 0; i < player.getBombas().size(); i++) {
			Bomba bomba = player.getBombas().get(i);
			graficos.drawImage(bomba.getBombaImagem(), bomba.getX(),
					bomba.getY(), this);
			

			if (bomba.isExplosaoIsVisible() == true) {
				if (bomba.getExplosao().getFogos().size() == 0) {
					explodirBloco(bomba.getExplosao().getFogoBaixo(), player);
					explodirBloco(bomba.getExplosao().getFogoCima(), player);
					explodirBloco(bomba.getExplosao().getFogoEsquerda(), player);
					explodirBloco(bomba.getExplosao().getFogoDireita(), player);
					
					
					
					bomba.setExplosaoIsVisible(false);
					player.getBombas().remove(bomba);
					player.setNumeroBombasEmJogo(player
							.getNumeroBombasEmJogo() - 1);
				} else if (bomba.getExplosao().getFogos().size() > 0) {
					

					corrigirExplosaoComParede(bomba.getExplosao().getFogoBaixo());
					corrigirExplosaoComParede(bomba.getExplosao().getFogoCima());
					corrigirExplosaoComParede(bomba.getExplosao().getFogoDireita());
					corrigirExplosaoComParede(bomba.getExplosao().getFogoEsquerda());

					corrigirExplosaoComBloco(bomba.getExplosao().getFogoBaixo());
					corrigirExplosaoComBloco(bomba.getExplosao().getFogoCima());
					corrigirExplosaoComBloco(bomba.getExplosao().getFogoDireita());
					corrigirExplosaoComBloco(bomba.getExplosao().getFogoEsquerda());

					corrigirExplosaoComBomba(bomba.getExplosao().getFogoDireita(), player);
					corrigirExplosaoComBomba(bomba.getExplosao().getFogoBaixo(), player);
					corrigirExplosaoComBomba(bomba.getExplosao().getFogoCima(), player);
					corrigirExplosaoComBomba(bomba.getExplosao().getFogoEsquerda(), player);

					matarPlayer(bomba.getExplosao().getFogoEsquerda());
					matarPlayer(bomba.getExplosao().getFogoDireita());
					matarPlayer(bomba.getExplosao().getFogoCima());
					matarPlayer(bomba.getExplosao().getFogoBaixo());
					matarPlayer(bomba.getExplosao().getFogoCentro());
					
					destruirUpgrade(bomba.getExplosao().getFogoBaixo());
					destruirUpgrade(bomba.getExplosao().getFogoCima());
					destruirUpgrade(bomba.getExplosao().getFogoDireita());
					destruirUpgrade(bomba.getExplosao().getFogoEsquerda());
					destruirUpgrade(bomba.getExplosao().getFogoCentro());
					
					for (int j = 0; j < bomba.getExplosao().getFogoBaixo()
							.size(); j++) { // BAIXO
						Fogo fogo = bomba.getExplosao().getFogoBaixo().get(j);
						graficos.drawImage(fogo.getFogoImagem(), fogo.getX(),
								fogo.getY(), this);
					}
					for (int j = 0; j < bomba.getExplosao().getFogoCima()
							.size(); j++) { // CIMA
						Fogo fogo = bomba.getExplosao().getFogoCima().get(j);
						graficos.drawImage(fogo.getFogoImagem(), fogo.getX(),
								fogo.getY(), this);
					}
					for (int j = 0; j < bomba.getExplosao().getFogoDireita()
							.size(); j++) { // DIREITA
						Fogo fogo = bomba.getExplosao().getFogoDireita().get(j);
						graficos.drawImage(fogo.getFogoImagem(), fogo.getX(),
								fogo.getY(), this);
					}
					for (int j = 0; j < bomba.getExplosao().getFogoEsquerda()
							.size(); j++) { // ESQUERDA
						Fogo fogo = bomba.getExplosao().getFogoEsquerda()
								.get(j);
						graficos.drawImage(fogo.getFogoImagem(), fogo.getX(),
								fogo.getY(), this);
					}
					//CENTRO
					Fogo fogo = bomba.getExplosao().getFogoCentro().get(0);					
					graficos.drawImage(fogo.getFogoImagem(),fogo.getX(), fogo.getY(), this);
					
					
				}
			}
		}
	}

	private void destruirUpgrade(ArrayList<Fogo> fogoBaixo) {
		Rectangle recFogo;
		Rectangle recUpgrade;
		for( int j = 0 ; j < mapa.getUpgrades().size() ; j++){
			Upgrade  upgrade = mapa.getUpgrades().get(j);
			if(upgrade != null){
				recUpgrade = mapa.getUpgrades().get(j).getBounds();
				for(int i = 0 ; i < fogoBaixo.size() ; i++){
					recFogo = fogoBaixo.get(i).getBounds();
					if(recFogo.intersects(recUpgrade)){
						mapa.getUpgrades().remove(mapa.getUpgrades().get(j--));
					}
				}
			}
		}
		
	}

	public void corrigirExplosaoComBloco(ArrayList<Fogo> direcaoFogo) {
		Rectangle recBloco;
		Rectangle recFogo;
		int cont = 0;
		for (int i = 0; i < mapa.getDestrutiveis().size(); i++) {
			recBloco = mapa.getDestrutiveis().get(i).getBounds();
			cont = 0;
			for (int j = 0; j < direcaoFogo.size(); j++) {
				recFogo = direcaoFogo.get(j).getBounds();
				if (cont == 1) {
					direcaoFogo.remove(direcaoFogo.get(j));
				} else if (recFogo.intersects(recBloco)) {
					cont = 1;
				}
			}
		}

	}

	public void corrigirExplosaoComBomba(ArrayList<Fogo> direcaoFogo, Personagem player) {
		Rectangle recBomba;
		Rectangle recFogo;
		int cont = 0;
		for (int i = 0; i < player.getBombas().size(); i++) {
			recBomba = player.getBombas().get(i).getBounds();
			cont = 0;
			for (int j = 0; j < direcaoFogo.size(); j++) {
				recFogo = direcaoFogo.get(j).getBounds();
				if (cont == 1) {
					direcaoFogo.remove(direcaoFogo.get(j));
					
				} else if (recFogo.intersects(recBomba)) {
					cont = 1;
					explodirBomba(direcaoFogo);
					
				}
			}
		}

	}

	public void corrigirExplosaoComParede(ArrayList<Fogo> direcaoFogo) {
		Rectangle recParede;
		Rectangle recFogo;
		int cont = 0;
		for (int i = 0; i < mapa.getParedes().size(); i++) {
			recParede = mapa.getParedes().get(i).getBounds();
			cont = 0;
			for (int j = 0; j < direcaoFogo.size(); j++) {
				recFogo = direcaoFogo.get(j).getBounds();
				if (recFogo.intersects(recParede) || (cont == 1)) {
					direcaoFogo.remove(direcaoFogo.get(j--));
					cont = 1;
				}

			}
		}

	}

	
	private void pegarUpgrade(Personagem player){
		Rectangle recUpgrade;
		Rectangle recPersonagem;
		Upgrade upgrade;
		for( int i = 0 ; i < mapa.getUpgrades().size() ; i++){
			upgrade = mapa.getUpgrades().get(i);
			if(upgrade != null){
				recUpgrade = upgrade.getBounds();
				recPersonagem = player.getBounds();
				if(recPersonagem.intersects(recUpgrade)){
					if(upgrade.getAtributo() == "BOMBA"){
						player.setNumeroBomba(player.getNumeroBomba() + 1);
						mapa.getUpgrades().remove(upgrade);
					}
					if(upgrade.getAtributo() == "FOGO"){
						player.setRangeExplosao(player.getRangeExplosao() + 1);
						mapa.getUpgrades().remove(upgrade);
					}
					if(upgrade.getAtributo() == "VIDA"){
						player.setVida(player.getVida() + 1);
						mapa.getUpgrades().remove(upgrade);
					}
					if(upgrade.getAtributo() == "VELOCIDADE"){
						player.setVelocidade(player.getVelocidade() + 1);
						mapa.getUpgrades().remove(upgrade);
					}
					
				}
			}
		}
	}
	
	
	public void explodirBloco(ArrayList<Fogo> direcaoFogo, Personagem player) {
		Rectangle recBloco;
		Rectangle recFogo;
		
		for (int j = 0; j < player.getBombas().size(); j++) {
			Bomba bomba = player.getBombas().get(j);
			if (bomba.isExplosaoIsVisible() == true) {
				if (bomba.getExplosao().getFogos().size() == 0) {
					for (int k = 0; k < direcaoFogo.size(); k++) {
						recFogo = direcaoFogo.get(k).getBounds();
						for (int i = 0; i < mapa.getDestrutiveis().size(); i++) {
							BlocoDestrutivel bloco = mapa.getDestrutiveis()
									.get(i);
							recBloco = bloco.getBounds();
							
							if (recFogo.intersects(recBloco)) {
								mapa.getUpgrades().add(bloco.getUpgrade());
								
								mapa.getDestrutiveis().remove(bloco);
							}
						}
					}
				}
			}
		}
	}
	
	private void matarPlayer(ArrayList<Fogo> direcaoFogo){
		Rectangle recFogo;
		Rectangle recPlayer2;
		Rectangle recPlayer1;
		for (int k = 0; k < direcaoFogo.size(); k++) {
			recFogo = direcaoFogo.get(k).getBounds();
			recPlayer2 = player2.getBounds();
			recPlayer1 = player1.getBounds();			
			if (recFogo.intersects(recPlayer1)) {
				if(player1.isVulneravel() == true){
					player1.setVida(player1.getVida() - 1);
					player1.invulneravel();
				}
			}
			if(recFogo.intersects(recPlayer2)){
				if(player2.isVulneravel() == true){
					player2.setVida(player2.getVida() - 1);
					player2.invulneravel();
				}
			}
			
		}
	}
	
	public void explodirBomba(ArrayList<Fogo> direcaoFogo) {
		Rectangle recBomba;
		Rectangle recFogo;
		Bomba bomba;

		for ( int i = 0 ; i < direcaoFogo.size() ; i++ ){
			recFogo = direcaoFogo.get(i).getBounds();
			for ( int j = 0 ; j < player1.getBombas().size() ; j++ ){
				bomba = player1.getBombas().get(j);
				recBomba = bomba.getBounds();
				if(recFogo.intersects(recBomba)){
					if(bomba.isBombaIsVisivel() == true){
						bomba.explodir();
					}
				}	
			}
		}
		
		for ( int i = 0 ; i < direcaoFogo.size() ; i++ ){
			recFogo = direcaoFogo.get(i).getBounds();
			for ( int j = 0 ; j < player2.getBombas().size() ; j++ ){
				bomba = player2.getBombas().get(j);
				recBomba = bomba.getBounds();
				if(recFogo.intersects(recBomba)){
					if(bomba.isBombaIsVisivel() == true){
						bomba.explodir();
					}
				}	
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (naoTemColisaoY()) {
			player1.mexerY();
		}
		if(naoTemColisaoYPlayer2()){
			player2.mexerY();
		}
		
		
		
		if (naoTemColisaoX()) {
			player1.mexerX();
		}
		if(naoTemColisaoXPlayer2()){
			player2.mexerX();
		}
		repaint();
	}
	
	

	public boolean naoTemColisaoX() {
		Rectangle rectPersonagem = player1.getNextXBounds();
		return naoTemColisao(rectPersonagem);

	}

	public boolean naoTemColisaoY() {
		Rectangle rectPersonagem = player1.getNextYBounds();
		return naoTemColisao(rectPersonagem);
	}

	
	public boolean naoTemColisaoXPlayer2() {
		Rectangle rectPersonagem = player2.getNextXBounds();
		return naoTemColisao(rectPersonagem);

	}

	public boolean naoTemColisaoYPlayer2() {
		Rectangle rectPersonagem = player2.getNextYBounds();
		return naoTemColisao(rectPersonagem);
	}

	
	private boolean naoTemColisao(Rectangle rectPersonagem) {
		Rectangle recParede;
		Parede parede;
		Rectangle recBloco;
		BlocoDestrutivel bloco;
		Rectangle recBomba;
		Bomba bomba;
		for (int i = 0; i < mapa.getParedes().size(); i++) {
			parede = mapa.getParedes().get(i);
			recParede = parede.getBounds();
			if (rectPersonagem.intersects(recParede)) {
				return false;
			}
		}
		for (int i = 0; i < mapa.getDestrutiveis().size(); i++) {
			bloco = mapa.getDestrutiveis().get(i);
			recBloco = bloco.getBounds();
			if (rectPersonagem.intersects(recBloco)) {
				return false;
			}
		}
		for (int i = 0; i < player1.getBombas().size(); i++) {
			bomba = player1.getBombas().get(i);
			recBomba = bomba.getBounds();
			if ((player1.getNextXBounds().intersects(recBomba) == false)
					|| (player1.getNextYBounds().intersects(recBomba)) == false) {
				if (rectPersonagem.intersects(recBomba)) {

					return false;
				}

			}
		}
		for (int i = 0; i < player2.getBombas().size(); i++) {
			bomba = player2.getBombas().get(i);
			recBomba = bomba.getBounds();
			if ((player2.getNextXBounds().intersects(recBomba) == false)
					|| (player2.getNextYBounds().intersects(recBomba)) == false) {
				if (rectPersonagem.intersects(recBomba)) {

					return false;
				}

			}
		}

		return true;
	}

	private class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			player1.keyPressed(e);
			player2.keyPressedP2(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player1.keyReleased(e);
			player2.keyReleasedP2(e);
		}

	}
}
