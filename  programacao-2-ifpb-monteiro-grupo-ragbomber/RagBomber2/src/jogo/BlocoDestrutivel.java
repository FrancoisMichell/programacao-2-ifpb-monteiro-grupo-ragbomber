package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BlocoDestrutivel {
	private Image blocoImagem;
	private int x,  largura;
	private int y, altura;
	private Upgrade upgrade;
	
	public BlocoDestrutivel(int x, int y){
		
			this.x = x;
			this.y = y;
			
			ImageIcon referencia = new ImageIcon("Imagens\\_parede.jpg");
			blocoImagem = referencia.getImage();
			
			this.largura = blocoImagem.getWidth(null);
			this.altura = blocoImagem.getHeight(null);
	}
	public void gerarUpgrade(){
		
		int gerarUpgrade = (int) (1+Math.random()*2);
		if(gerarUpgrade == 1){
			upgrade = new Upgrade(getX(), getY());
			
		}	
		
	}
	
	

	public Upgrade getUpgrade() {
		gerarUpgrade();
		return upgrade;
	}
	
	public Image getBlocoImagem() {
		return blocoImagem;
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

	
	
}
