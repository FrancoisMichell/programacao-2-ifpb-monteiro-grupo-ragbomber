package TesteSons;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends JFrame{

	BufferedImage backBuffer;
	int FPS = 30;
	int largura = 500;
	int altura = 500;
	
	
	public void atualizar() {
		
	}
	
	public void desenharGraficos() {
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();
		
		
		g.drawImage(backBuffer, 0, 0, null);
	}
	
	public void inicializar() {
		setTitle("Tela jogo");
		//setSize()
	}
	
}
