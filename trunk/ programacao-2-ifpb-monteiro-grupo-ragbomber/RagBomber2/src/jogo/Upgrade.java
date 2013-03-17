package jogo;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Upgrade {
	private Image upgradeImagem;
	private int largura, altura;
	private int x, y;
	private String atributo;


	public Upgrade(int x, int y){
		
		this.x = x;
		this.y = y;
		
		int sorteioUpgrade = (int) (1+Math.random()*4);  
		
		if(sorteioUpgrade == 1){
		ImageIcon bombaPower = new ImageIcon("Imagens\\_bomba.png");
		upgradeImagem = bombaPower.getImage();
		atributo = "BOMBA";
		}
		if(sorteioUpgrade == 2){
		ImageIcon botaPower = new ImageIcon("Imagens\\_bota.png");
		upgradeImagem = botaPower.getImage();
		atributo = "VELOCIDADE";
		}
		if(sorteioUpgrade == 3){
		ImageIcon coracaoPower = new ImageIcon("Imagens\\_coracao.png");
		upgradeImagem = coracaoPower.getImage();
		atributo = "VIDA";
		}
		if(sorteioUpgrade == 4){
		ImageIcon fogoPower = new ImageIcon("Imagens\\_fogo.png");
		upgradeImagem = fogoPower.getImage();
		atributo = "FOGO";
		}
		this.largura = upgradeImagem.getWidth(null);
		this.altura = upgradeImagem.getHeight(null);
		
	}
	
	

	public String getAtributo() {
		return atributo;
	}

	public Image getUpgradeImagem() {
		return upgradeImagem;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, largura, altura);
	}
	
}
