package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Fogo {
	private Image fogoImagem;
	private int x,  largura;
	private int y, altura;
	
	
	public Fogo(int x, int y){
		this.x = x;
		this.y = y;
		
		ImageIcon referencia = new ImageIcon("Imagens\\fire.png");
		fogoImagem = referencia.getImage();
		
		this.largura = 40;
		this.altura = 40;
	}
	
	
	
	
	public Image getFogoImagem() {
		return fogoImagem;
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
