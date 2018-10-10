package es.unex.cum.reto;
/**
 * Clase que contiene las coordendas de los puntos de los vertices
 * @author marco
 *
 */
public class Punto {
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

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
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	
	public double distancia (Punto P2) {
		double distancia = 0;
		distancia = (double)Math.hypot((x - P2.getX()), (y - P2.getY()));
		return distancia;
	}
}
