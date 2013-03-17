package jogo;

import javax.swing.JFrame;

public class Iniciar extends JFrame{
	
	public Iniciar() {
		
		Tela tela = new Tela();
		add(tela);
		addKeyListener(tela.getKeyListeners()[0]);
		setTitle("RagBomber 2.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(760,625);
		setLocationRelativeTo(null);
		setFocusable(true);
		setResizable(false);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new Iniciar();
	}


}
