package jogo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Tela extends JPanel implements ActionListener{

	private Parede parede;
	BufferedImage backBuffer;
	private Personagem personagem;
	private Image fundo;
	private Image paredeImagem;
	private Timer time;
	
	private boolean emJogo;
	
	public void atualizar(){
		
	}

	public Tela() {
		
		setDoubleBuffered(true);
		setFocusable(true);
		addKeyListener(new TecladoAdapter());
		personagem = new Personagem();
		
		ImageIcon referencia = new ImageIcon("Imagens\\_fundo.jpg");
		fundo = referencia.getImage();

		time = new Timer(5, this);
		time.start();
		
	}
	
	
	
	public void paint(Graphics g){	
		emJogo = true;
		if(emJogo) {
		
		
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(personagem.getImagem(), personagem.getX(), personagem.getY(), this);

		String[] level = {"PPPPPPPPPPPPPPPPPPP",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
				"P B B B B B B B B P",
				"P                 P",
		"PPPPPPPPPPPPPPPPPPP"};

		parede = new Parede();

		montarMapa(g, level);
		}
		g.dispose();
	}

	private void montarMapa(Graphics g, String[] level) {
		ArrayList<Integer> esqueleto = new ArrayList<Integer>();
		ImageIcon referencia = new ImageIcon("imagens\\_tela_principal.jpg");
		ImageIcon refe = new ImageIcon("imagens\\2.png");
		paredeImagem = refe.getImage();
		
		Graphics2D graficos = (Graphics2D) g;
		
		int x = 0, y= 0;
		for (String coordenada : level) {
			for (Character coords : coordenada.toCharArray()) {
				String posicao = Character.toString(coords);
				if  ( posicao.equals("P")) {
					esqueleto.add(x);
					esqueleto.add(y);
				}
				if (posicao.equals("B")){
					esqueleto.add(x);
					esqueleto.add(y);

				}
				x += 40;				
			}
			y += 40;
			x = 0;
		}
		for (int i = 0 ; i < esqueleto.size()-1; i+=2){
			graficos.drawImage(paredeImagem, esqueleto.get(i), esqueleto.get(i+1), this);

		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		personagem.naoSairTela();
		
		
		System.out.println("ahdah");
		repaint();
	}
	
	private class TecladoAdapter extends KeyAdapter{
		
		
		@Override
		public void keyPressed(KeyEvent e){
		
			System.out.println("sadasdasda");
			personagem.keyPressedX(e);
			personagem.keyPressedY(e);
		
		} 
		@Override
		public void keyReleased(KeyEvent e) {
			
			personagem.keyReleased(e);	
		}
	}

	

}
