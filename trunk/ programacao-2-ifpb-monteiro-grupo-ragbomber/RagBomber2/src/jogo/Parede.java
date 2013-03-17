package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Parede {
	private Image paredeImagem;
	private int largura, altura;
	private int posicaoX, posicaoY;
	
	public Parede(int posicaoX, int posicaoY){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		
		ImageIcon referencia = new ImageIcon("Imagens\\2.png");
		paredeImagem = referencia.getImage();
		
		this.largura = paredeImagem.getWidth(null);
		this.altura = paredeImagem.getHeight(null);
		
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public int getPosicaoX() {
		return posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(posicaoX, posicaoY, largura, altura);
	}

	public Image getParedeImagem() {
		return paredeImagem;
	}

}
