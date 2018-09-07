package ClasesGeneralesFueraDeArbolH;

public class Dimension {

	//atributos
	
	protected int x;
	protected int y;
	
	//constructor
	
	public Dimension(int xx , int yy) {
		x=xx;
		y=yy;
	}
	
	//metodos
	
	public int getAncho() {
		return x;
	}
	
	public int getAlto() {
		return y;
	}
	
	public void setAncho(int xx) {
		x=xx;
	}
	
	public void setAlto(int yy) {
		y=yy;
	}
}
