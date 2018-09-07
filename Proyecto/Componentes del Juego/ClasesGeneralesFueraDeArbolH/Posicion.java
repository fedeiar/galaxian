package ClasesGeneralesFueraDeArbolH;

public class Posicion {

	//atributos
	
	protected int x;
	protected int y;
	
	//constructor
	
	public Posicion(int xx , int yy) {
		x=xx;
		y=yy;
	}
	
	//metodos
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
	public void setx(int xx) {
		x=xx;
	}
	
	public void sety(int yy) {
		y=yy;
	}
}
