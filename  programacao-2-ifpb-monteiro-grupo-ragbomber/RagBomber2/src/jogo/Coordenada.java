package jogo;

public class Coordenada {

	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Coordenada){
			Coordenada coordenada = (Coordenada) arg0;
			return coordenada.getX() == getX() && coordenada.getY() == getY();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getX() + " " + getY();
	}
	
}
