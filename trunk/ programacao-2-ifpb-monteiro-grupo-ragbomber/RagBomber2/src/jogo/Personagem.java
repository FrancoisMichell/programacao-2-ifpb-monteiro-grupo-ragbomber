package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;


public class Personagem{
	ImageIcon player = new ImageIcon("Imagens\\Player2Frente.gif");
	ArrayList<Bomba> bombas = new ArrayList<Bomba>();
	
	private int numeroBomba, numeroBombasEmJogo , velocidade, rangeExplosao, vida;

	private int x, y;
	private int dx, dy;
	private int largura, altura;
	private Image imagem;

	private boolean vulneravel;

	public Personagem() {
		this.rangeExplosao = 1;
		this.numeroBomba = 1;
		this.numeroBombasEmJogo = 0;
		this.velocidade =1;
		this.vida = 1;
		imagem = player.getImage();
		this.vulneravel = true;
//		altura = imagem.getHeight(null);
//		largura = imagem.getWidth(null);
		
		altura = 35;
		largura = 35;

		this.x = x;
		this.y = y;
		mexerX();
		mexerY();
		
		

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
			
		}

		if(codigo == KeyEvent.VK_DOWN) {
			dy = velocidade;
		}

		if (codigo == KeyEvent.VK_LEFT) {
			dx = -velocidade;
			
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = velocidade;
		}

	}

	public void keyReleased(KeyEvent e){

		int codigo = e.getKeyCode();

		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
	}
		
		
		public void keyPressedP2(KeyEvent e){

			int codigo = e.getKeyCode();
			
			if(codigo == KeyEvent.VK_SPACE){
				colocarBomba();
			}

			if (codigo == KeyEvent.VK_W) {
				dy = -velocidade;
				
			}

			if(codigo == KeyEvent.VK_S) {
				dy = velocidade;
			}

			if (codigo == KeyEvent.VK_A) {
				dx = -velocidade;
				
			}
			if(codigo == KeyEvent.VK_D) {
				dx = velocidade;
			}

		}

		public void keyReleasedP2(KeyEvent e){

			int codigo = e.getKeyCode();

			if (codigo == KeyEvent.VK_W) {
				dy = 0;
			}
			if(codigo == KeyEvent.VK_S) {
				dy = 0;
			}
			if (codigo == KeyEvent.VK_A) {
				dx = 0;
			}
			if(codigo == KeyEvent.VK_D) {
				dx = 0;
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

	public Image getImagem() {
		return imagem;
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
