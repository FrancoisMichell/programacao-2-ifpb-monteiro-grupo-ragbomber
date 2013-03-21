package jogo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class Bomba {
	private Image bombaImagem;
	private int x,  largura;
	private int y, altura;
	private Explosao explosao;
	private boolean explosaoIsVisivel;
	private int rangeExplosao;
	private boolean bombaIsVisivel;

	public Bomba(int x, int y, int rangeExplosao){
		
			this.x = corrigirPosicao(x);
			this.y = corrigirPosicao(y);
			
			this.explosaoIsVisivel = false;
			this.bombaIsVisivel = true;
			
			this.rangeExplosao = rangeExplosao;
			
			ImageIcon referencia = new ImageIcon("Imagens\\Bomba.gif");
			bombaImagem = referencia.getImage();
			
			this.largura = bombaImagem.getWidth(null);
			this.altura = bombaImagem.getHeight(null);
			
			// Contagem regressiva para a bomba explodir
			Timer timer = new Timer();
		    int contRegressiva = 3500;
			timer.schedule(new RemindTask(), contRegressiva);
						
	}
	
	public class RemindTask extends TimerTask {
	    public void run() {
	    	
	    	bombaIsVisivel = false;
	    	explodir(); 
	    	
	      }
	    }
	
	public int corrigirPosicao(int posicao){
		int verificar = posicao % 40;
		if(verificar == 0){
			return posicao;
		}
		if(verificar <= 20){
			return ((posicao) - verificar);
		}
		if(verificar > 20){
			return((posicao+40) - verificar);
		}else{
			return 0;
		}
	}
	
	public void explodir(){
		
		explosao = new Explosao(getX(),getY(),getRangeExplosao());
		explosaoIsVisivel = true;
	}
	
	
	public Explosao getExplosao() {
		return explosao;
	}
	
	public Image getBombaImagem() {
		return bombaImagem;
	}
	public int getX() {
		return x;
	}
	public int getLargura() {
		return largura;
	}
	public int getY() {
		return y;
	}
	public int getAltura() {
		return altura;
	}

	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
	public int getRangeExplosao() {
		return rangeExplosao;
	}
	public boolean isExplosaoIsVisible() {
		return explosaoIsVisivel;
	}

	public void setExplosaoIsVisible(boolean explosaoIsVisible) {
		this.explosaoIsVisivel = explosaoIsVisible;
	}
	
	public boolean isBombaIsVisivel() {
		return bombaIsVisivel;
	}

	public void setBombaIsVisivel(boolean bombaIsVisivel) {
		this.bombaIsVisivel = bombaIsVisivel;
	}


}
