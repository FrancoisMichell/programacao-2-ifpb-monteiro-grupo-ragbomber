package jogo;


import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;


public class Personagem{
	
	
	ImageIcon imagemPlayer1 = new ImageIcon("Imagens\\Frente p1.gif");
	ImageIcon imagemPlayer2 = new ImageIcon("Imagens\\Frente p2 .gif");
	
	ArrayList<Bomba> bombas = new ArrayList<Bomba>();
	
	private int numeroBomba, numeroBombasEmJogo , velocidade, rangeExplosao, vida;

	private int x, y;
	private int dx, dy;
	private int largura, altura;
	private Image imagem1, imagem2;

	

	private boolean vulneravel;

	public Personagem(int x, int y) {
		this.rangeExplosao = 10;
		this.numeroBomba = 10;
		this.numeroBombasEmJogo = 0;
		this.velocidade =2;
		this.vida = 10;
		
		
		imagem1 = imagemPlayer1.getImage();
		imagem2 = imagemPlayer2.getImage();
		this.vulneravel = true;
		altura = imagem1.getHeight(null);
		largura = imagem1.getWidth(null);
		
		this.x = x;
		this.y = y;
		mexerX();
		mexerY();
		
		

	}
	
	public void PersonagemRemoto() {
		// TODO Auto-generated constructor stub
	}

	private class RemindTask extends TimerTask {
	    public void run() {
	    	

	    	setVulneravel(true);
	      }
	    }
	public void invulneravel(){
		setVulneravel(false);
		Timer timer = new Timer();
	    int contRegressiva = 3000;
		timer.schedule(new RemindTask(), contRegressiva);
		
	}
	
		
	
	public void colocarBomba(){
		if(numeroBombasEmJogo < numeroBomba){
			
			Bomba bomba = new Bomba(getX(), getY(), getRangeExplosao());
			bombas.add(bomba);
			Rectangle RecBomba = bomba.getBounds();
			for(int i = 0 ; i < numeroBombasEmJogo; i ++){
				Rectangle verificar = bombas.get(i).getBounds();				
				if( RecBomba.intersects(verificar)){
					numeroBombasEmJogo -=1;
					bombas.remove(bomba);
				}
			}
			
			numeroBombasEmJogo += 1;
			
		}		
	}

	public void mexerX() {
		x += dx;
	}

	public void mexerY() {
		y += dy;
	}

	public void keyPressed(KeyEvent e){

		int codigo = e.getKeyCode();
		
		if(codigo == KeyEvent.VK_ENTER){
			colocarBomba();
		}

		if (codigo == KeyEvent.VK_UP) {
			dy = -velocidade;
			ImageIcon player = new ImageIcon("Imagens\\Costas p1.gif");
			imagem1 = player.getImage();
			
		}

		if(codigo == KeyEvent.VK_DOWN) {
			dy = velocidade;
			ImageIcon player = new ImageIcon("Imagens\\Frente p1.gif");
			imagem1 = player.getImage();
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -velocidade;
			ImageIcon player = new ImageIcon("Imagens\\Esquerda p1.gif");
			imagem1 = player.getImage();
			
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = velocidade;
			ImageIcon player = new ImageIcon("Imagens\\Direita p1.gif");
			imagem1 = player.getImage();
		}

	}

	public void keyReleased(KeyEvent e){

		int codigo = e.getKeyCode();

		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
			ImageIcon player = new ImageIcon("Imagens\\CostasParado p1.png");
			imagem1 = player.getImage();
		}
		if(codigo == KeyEvent.VK_DOWN) {
			dy = 0;
			ImageIcon player = new ImageIcon("Imagens\\FrenteParado p1.png");
			imagem1 = player.getImage();
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
			ImageIcon player = new ImageIcon("Imagens\\EsquerdaParado p1.png");
			imagem1 = player.getImage();
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
			ImageIcon player = new ImageIcon("Imagens\\DireitaParado p1.png");
			imagem1 = player.getImage();
		}
	}
		
		
		public void keyPressedP2(KeyEvent e){

			int codigo = e.getKeyCode();
			
			if(codigo == KeyEvent.VK_SPACE){
				colocarBomba();
			}

			if (codigo == KeyEvent.VK_W) {
				dy = -velocidade;
				ImageIcon player = new ImageIcon("Imagens\\Costas p2.gif");
				imagem2 = player.getImage();
			}

			if(codigo == KeyEvent.VK_S) {
				dy = velocidade;
				ImageIcon player = new ImageIcon("Imagens\\Frente p2.gif");
				imagem2 = player.getImage();
			}

			if (codigo == KeyEvent.VK_A) {
				dx = -velocidade;
				ImageIcon player = new ImageIcon("Imagens\\Esquerda p2.gif");
				imagem2 = player.getImage();
				
			}
			if(codigo == KeyEvent.VK_D) {
				dx = velocidade;
				ImageIcon player = new ImageIcon("Imagens\\Direita p2.gif");
				imagem2 = player.getImage();
			}

		}

		public void keyReleasedP2(KeyEvent e){

			int codigo = e.getKeyCode();

			if (codigo == KeyEvent.VK_W) {
				dy = 0;
				ImageIcon player = new ImageIcon("Imagens\\CostasParado p2.png");
				imagem2 = player.getImage();
			}
			if(codigo == KeyEvent.VK_S) {
				dy = 0;
				ImageIcon player = new ImageIcon("Imagens\\FrenteParado p2.png");
				imagem2 = player.getImage();
			}
			if (codigo == KeyEvent.VK_A) {
				dx = 0;
				ImageIcon player = new ImageIcon("Imagens\\EsquerdaParado p2.png");
				imagem2 = player.getImage();
			}
			if(codigo == KeyEvent.VK_D) {
				dx = 0;
				ImageIcon player = new ImageIcon("Imagens\\DireitaParado p2.png");
				imagem2 = player.getImage();
			}

	}
	public int getNumeroBomba() {
		return numeroBomba;
	}

	public void setNumeroBomba(int numeroBomba) {
		this.numeroBomba = numeroBomba;
	}
	
	public void setNumeroBombasEmJogo(int numeroBombasEmJogo) {
		this.numeroBombasEmJogo = numeroBombasEmJogo;
	}
	
	public int getNumeroBombasEmJogo(){
		return numeroBombasEmJogo;
	}
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}
	
	public int getRangeExplosao() {
		return rangeExplosao;
	}
	
	public void setRangeExplosao(int rangeExplosao) {
		this.rangeExplosao = rangeExplosao;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}
	
	public Image getImagem2() {
		return imagem2;
	}

	public Image getImagem() {
		return imagem1;
	}

	public boolean isVulneravel() {
		return vulneravel;
	}

	public void setVulneravel(boolean vulneravel) {
		this.vulneravel = vulneravel;
	}
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
	public Rectangle getNextXBounds(){
		return new Rectangle(x+dx, y, largura, altura);
	}
	
	public Rectangle getNextYBounds(){
		return new Rectangle(x, y+dy, largura, altura);
	}

	public ArrayList<Bomba> getBombas() {
		return bombas;
	}
}
