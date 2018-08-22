package TDAArbol;
import TDALista.*;
public class Tnodo<E> implements Position<E>  {
	
	//atributos
	
	private E elemento;
	private Tnodo<E> padre;
	private PositionList<Tnodo<E>> hijos; 
	
	//constructores
	
	public Tnodo( E elemento, Tnodo<E> padre ) {
			this.elemento = elemento;
			this.padre = padre;
			hijos = new ListaDE<Tnodo<E>>();
	}

	public Tnodo(E elemento ) { 
		this( elemento, null); 
	}

	//metodos
	
	public E element() {
		return elemento;
	}
	
	public PositionList<Tnodo<E>> getHijos() {
		return hijos; 
	}
	
	public void setElemento( E elemento ) { 
		this.elemento = elemento;
	}
	
	public Tnodo<E> getPadre() { 
		return padre; 
	}
	
	public void setPadre( Tnodo<E> padre ) {
		this.padre = padre;
	}
}