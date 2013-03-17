package TesteMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PainelJogo extends JPanel implements Runnable{

	private static final int largura = 400;
	private static final int altura = 500;
	
	private Thread animador;
	private volatile boolean rodando = false;
	
	private volatile boolean fimDeJogo = false;
	
	
	public PainelJogo(){
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(largura, altura));
	
		setFocusable(true);
		requestFocus(); //receber eventos do teclado
		readyForTermination();
		
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				testPress(e.getX(), e.getY());
			}
		});
		
	}

	private void readyForTermination() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				int keyCode = e.getKeyCode();
				
				if((keyCode == KeyEvent.VK_ESCAPE) ||
				   (keyCode == KeyEvent.VK_Q) ||
				   (keyCode == KeyEvent.VK_END) ||
				  ((keyCode == KeyEvent.VK_C) && e.isControlDown())	) {
					rodando = false;
				}
			}
		});
	}

	private void testPress(int x, int y) {
		if (!fimDeJogo) {
			
		}
	}
	
	
	public void addNotify(){
		super.addNotify();
		comecarJogo();
	}
	
	
	private void comecarJogo() {
		if (animador == null || !rodando){
			animador = new Thread(this);
			animador.start();
		}
	}

	public void pararJogo(){
		rodando = false;
	}
	
	
	@Override
	public void run() {
		rodando = true;
		while(rodando) {
			gameUpdate();
			gameRender();
			pintaTela();
			try{
				Thread.sleep(20);
			}catch(InterruptedException e) {}
		}
		System.exit(0);
	}
	
	private void pintaTela() {
		Graphics g;
		
		try{
			g = this.getGraphics();
			if ((g != null) && (dbImage != null))
				g.drawImage(dbImage, 0, 0, null);
			Toolkit.getDefaultToolkit().sync(); //sincroniza o display em alguns sistemas
			g.dispose();
		}catch (Exception e) {
			System.out.println("Graphics context error: " + e);
		}
	}
	
	
	
	private void gameUpdate() {
		if(!fimDeJogo){
			
		}
	}
	
	
	private Graphics dbg;
	private Image dbImage = null;
	
	private void gameRender() {
		
		if (dbImage == null) {
			dbImage = createImage(largura, altura);
			
			if(dbImage == null) {
				System.out.println("dbImage é nulo");
				return;
			}else {
				dbg = dbImage.getGraphics();
			}
			
			dbg.setColor(Color.WHITE);
			dbg.fillRect(0, 0, largura, altura);
			
	
//			if(fimDeJogo) {
//				fimDeJogoMessage(dbg);
//			}
		}
	}

//	private void fimDeJogoMessage(Graphics g) {
//		String msg;
//		g.drawString(msg, x, y);
//	}
//	
//	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (dbImage != null) 
			g.drawImage(dbImage, 0, 0, null);
	}


}


