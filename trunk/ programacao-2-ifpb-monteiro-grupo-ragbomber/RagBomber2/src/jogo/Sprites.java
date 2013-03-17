package jogo;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Sprites {

	ImageIcon cenasFrente[];
	int x, y;
	int largura, altura;
	int cenaFrente = 0;
	int controlaVelocidade = 0;
	int velocidade = 5;
	
	public Sprites(int numeroDeCenas, int x, int y) {
		cenasFrente = new ImageIcon[numeroDeCenas];
		this.x = x;
		this.y = y;
	}
	
	public void animar() {
		cenaFrente += 1;
		if(cenaFrente == cenasFrente.length) {
			cenaFrente = 0;
		}
	}
	public void parar() {
		cenaFrente = 0;
	}
	
	
}
