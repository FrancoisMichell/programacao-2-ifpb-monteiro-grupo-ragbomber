package TesteMenu;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Worm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PainelJogo painel = new PainelJogo();
		
		Thread thread = new Thread(painel);
		
		thread.start();
	}

}
